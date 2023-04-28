package com.example.fitnesstestapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.databinding.LessonsDateItemBinding
import com.example.fitnesstestapp.databinding.LessonsItemBinding
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.presentation.helpers.bindingLifecycleError

class LessonsRvAdapter : RecyclerView.Adapter<LessonsBaseViewHolder>() {

    private val lessons = mutableListOf<LessonsModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun populateItems(newLessons: List<LessonsModel>) {
        lessons.clear()
        lessons.addAll(newLessons)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int = when (lessons[position]) {
        is LessonsModel.Lesson -> R.layout.lessons_item
        is LessonsModel.LessonDate -> R.layout.lessons_date_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsBaseViewHolder {

        val viewHolder = when (viewType) {
            R.layout.lessons_item -> LessonsBaseViewHolder.LessonsViewHolder(
                LessonsItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.lessons_date_item -> {
                val binding = LessonsDateItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                LessonsBaseViewHolder.LessonsDateViewHolder(binding)
            }
            else -> bindingLifecycleError()
        }
        return viewHolder
    }

    override fun getItemCount(): Int = lessons.size

    override fun onBindViewHolder(holder: LessonsBaseViewHolder, position: Int) {
        holder.setupViews(lessons[position])
    }

}