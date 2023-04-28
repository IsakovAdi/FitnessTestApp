package com.example.fitnesstestapp.presentation.ui.adapters

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.fitnesstestapp.databinding.LessonsDateItemBinding
import com.example.fitnesstestapp.databinding.LessonsItemBinding
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.presentation.helpers.formatISOAsDate

abstract class LessonsBaseViewHolder(private val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun setupViews(model: LessonsModel)


    class LessonsViewHolder(private val binding: LessonsItemBinding) :
        LessonsBaseViewHolder(binding) {

        override fun setupViews(model: LessonsModel) {
            val lesson = model as? LessonsModel.Lesson ?: return
            binding.apply {
                startTimeTv.text = lesson.startTime
                startColoredLine.setBackgroundColor(Color.parseColor(lesson.color))
                fitnessTypeTv.text = lesson.category
                endTimeTv.text = lesson.endTime
                locationTv.text = lesson.place
                trainerNameTv.text = lesson.coachName
                durationTv.text = lesson.duration
            }
        }
    }

    class LessonsDateViewHolder(private val binding: LessonsDateItemBinding) :
        LessonsBaseViewHolder(binding) {
        override fun setupViews(model: LessonsModel) {
            val lesson = model as? LessonsModel.LessonDate ?: return

            binding.lessonDateTv.text = lesson.date.formatISOAsDate().toString()
        }
    }
}