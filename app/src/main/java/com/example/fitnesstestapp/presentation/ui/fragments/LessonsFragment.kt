package com.example.fitnesstestapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.databinding.FragmentLessonsBinding
import com.example.fitnesstestapp.presentation.helpers.bindingLifecycleError
import com.example.fitnesstestapp.presentation.models.LessonUi
import com.example.fitnesstestapp.presentation.ui.activities.LessonDetailsActivity
import com.example.fitnesstestapp.presentation.ui.adapters.LessonsRvAdapter
import com.example.fitnesstestapp.presentation.ui.viewModels.LessonsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LessonsFragment : Fragment(), LessonsRvAdapter.RecyclerViewClickListener {

    private val binding by lazy {
        FragmentLessonsBinding.inflate(layoutInflater)
    }

    private val adapter by lazy { LessonsRvAdapter(this) }

    private val viewModel by viewModels<LessonsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeData()
    }

    private fun setupViews() = with(binding) {
        lessonsRv.adapter = adapter
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.lessonsFlow.collectLatest {
                adapter.lessons = it
            }
        }
    }

    override fun onItemClick(item: LessonUi) {
        when (item) {
            is LessonUi.Lesson -> {
                launchLessonDetailsFragment(lesson = item)
            }
            is LessonUi.LessonDateUi -> Unit
        }
    }


    private fun launchLessonDetailsFragment(lesson: LessonUi.Lesson) {
        requireContext().startActivity(
            LessonDetailsActivity.launchLessonDetailsFragment(
                requireContext(),
                lesson
            )
        )
    }

}