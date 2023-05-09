package com.example.fitnesstestapp.presentation.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.interactors.GetLessonsUseCase
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.presentation.models.LessonUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

private const val DEFAULT_CLOUD_ID = 2

@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val getLessonsUseCase: GetLessonsUseCase,
    private val mapper: Mapper<List<LessonsModel>, List<LessonUi>>,
    private val dispatchersProvider: DispatchersProvider,
) : ViewModel() {

    val lessonsFlow = getLessonsUseCase(DEFAULT_CLOUD_ID)
        .flowOn(dispatchersProvider.io())
        .map(mapper::map)
        .flowOn(dispatchersProvider.default())
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}