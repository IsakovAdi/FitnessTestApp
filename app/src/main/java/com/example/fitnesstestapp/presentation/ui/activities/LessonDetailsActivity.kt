package com.example.fitnesstestapp.presentation.ui.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.databinding.ActivityLessonDetailsBinding
import com.example.fitnesstestapp.presentation.models.LessonUi

class LessonDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLessonDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setContents()
    }

    private fun setContents() {
        val lesson: LessonUi.Lesson = intent.getParcelableExtra(LESSON)!!
        binding.apply {
//            Picasso.get().load(lesson.coach?.imageUrl).into(trainerImage)
            Glide.with(this@LessonDetailsActivity).load(lesson.coach?.imageUrl).centerCrop()
                .into(trainerImage)
            topTitle.text = lesson.lessonName
            fitnessTypeBackground.setBackgroundColor(Color.parseColor(lesson.color))
            trainerNameText.text = lesson.coach?.trainerName ?: ""
            trainerDesc.text = lesson.coach?.trainerPosition ?: ""
            lessonName.text = lesson.lessonName
            lessonTab.text = lesson.category
            lessonDesc.text = lesson.description
            lessonPlace.text = lesson.place
            lessonStart.text = lesson.startTime
            lessonEnd.text = lesson.endTime
            lessonDuration.text = lesson.duration
            when (lesson.category) {
                "Функциональный тренинг" -> fitnessTypeIcon.setImageResource(R.drawable.optional)
                "Силовые программы" -> fitnessTypeIcon.setImageResource(R.drawable.athletic)
                "Уроки смешанного формата" -> fitnessTypeIcon.setImageResource(R.drawable.smeshannyi)
                "Боевые искусства" -> fitnessTypeIcon.setImageResource(R.drawable.samooborona)
                "Водные уроки" -> fitnessTypeIcon.setImageResource(R.drawable.swimming)
                "Детский клуб" -> fitnessTypeIcon.setImageResource(R.drawable.boxing_jun)
                "Кардиопрограммы" -> fitnessTypeIcon.setImageResource(R.drawable.cardio)
                "Танцевальные уроки" -> fitnessTypeIcon.setImageResource(R.drawable.dancing)
                "Разум и тело" -> fitnessTypeIcon.setImageResource(R.drawable.razum_i_telo)
                "Детские водные программы" -> fitnessTypeIcon.setImageResource(R.drawable.kid_swimming)
            }
        }
    }

    companion object {
        fun launchLessonDetailsFragment(context: Context, lesson: LessonUi.Lesson): Intent {
            val intent = Intent(context, LessonDetailsActivity::class.java)
            intent.putExtra(LESSON, lesson)
            return intent
        }

        private const val LESSON = "lesson"
    }
}