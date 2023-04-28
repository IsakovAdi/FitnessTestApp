package com.example.fitnesstestapp.presentation.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesstestapp.domain.interactors.GetLessonsUseCase
import com.example.fitnesstestapp.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
private const val DEFAULT_CLOUD_ID = 2
    @HiltViewModel
class LessonsViewModel @Inject constructor(
    private val getLessonsUseCase: GetLessonsUseCase
):ViewModel() {

    val lessonsFlow = getLessonsUseCase(DEFAULT_CLOUD_ID)
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

}