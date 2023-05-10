package com.example.fitnesstestapp.presentation.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesstestapp.data.cloud.base.ResourceProvider
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.interactors.cloud.GetLessonsUseCase
import com.example.fitnesstestapp.domain.interactors.sotorage.GetLessonResourceFromStorageUseCase
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.presentation.models.LessonUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val DEFAULT_CLOUD_ID = 2

@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val getLessonsUseCase: GetLessonsUseCase,
    private val mapper: Mapper<List<LessonsModel>, List<LessonUi>>,
    private val dispatchersProvider: DispatchersProvider,
    private val resourceProvider: ResourceProvider,
    private val getLessonsFromStorageUseCase: GetLessonResourceFromStorageUseCase,
) : ViewModel() {

    private val _cloudError = MutableSharedFlow<String>(replay = 0)
    val cloudError get() = _cloudError.asSharedFlow()

    private val _storageError = MutableSharedFlow<String>(replay = 0)
    val storageError get() = _storageError.asSharedFlow()

    private val _storageLessons =
        MutableSharedFlow<List<LessonUi>>(1, 0, BufferOverflow.DROP_OLDEST)
    val storageLessons get() = _storageLessons.asSharedFlow()

    val lessonsFlow = getLessonsUseCase(DEFAULT_CLOUD_ID)
        .flowOn(dispatchersProvider.io())
        .map(mapper::map)
        .flowOn(dispatchersProvider.default())
        .catch { t ->
            _cloudError.emit(resourceProvider.handleException(t))
            getLessonsFromStorage()
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private fun getLessonsFromStorage() = viewModelScope.launch {
        kotlin.runCatching {
            getLessonsFromStorageUseCase()
        }.onSuccess {
            it.onEach { lessons ->
                _storageLessons.emit(mapper.map(lessons))
            }
        }.onFailure {
            _storageError.emit(it.message.toString())
        }
    }

}