package com.example.fitnesstestapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.databinding.LessonsDateItemBinding
import com.example.fitnesstestapp.databinding.LessonsItemBinding
import com.example.fitnesstestapp.presentation.helpers.bindingLifecycleError
import com.example.fitnesstestapp.presentation.models.LessonUi

class LessonsRvAdapter(
    private val listener: RecyclerViewClickListener,
) : RecyclerView.Adapter<LessonsBaseViewHolder>() {

    var lessons = listOf<LessonUi>()
        set(value) {
            val callback = LessonDiffCallback(lessons, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun getItemViewType(position: Int): Int = when (lessons[position]) {
        is LessonUi.Lesson -> R.layout.lessons_item
        is LessonUi.LessonDateUi -> R.layout.lessons_date_item
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
        holder.itemView.setOnClickListener {
            listener.onItemClick(lessons[position])
        }
    }

    interface RecyclerViewClickListener {
        fun onItemClick(item: LessonUi)
    }

}