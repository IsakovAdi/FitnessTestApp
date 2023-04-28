package com.example.fitnesstestapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.databinding.FragmentLessonsBinding
import com.example.fitnesstestapp.presentation.helpers.bindingLifecycleError
import com.example.fitnesstestapp.presentation.ui.adapters.LessonsRvAdapter
import com.example.fitnesstestapp.presentation.ui.viewModels.LessonsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LessonsFragment : Fragment() {

    private val binding by lazy {
        FragmentLessonsBinding.inflate(layoutInflater)
    }

    private val adapter by lazy { LessonsRvAdapter() }

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

    private fun observeData() = with(viewModel) {
        lessonsFlow.onEach(adapter::populateItems).launchIn(lifecycleScope)
    }

}