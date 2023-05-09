package com.example.fitnesstestapp.presentation.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.fitnesstestapp.presentation.models.LessonUi

class LessonDiffCallback(
    private val oldList: List<LessonUi>,
    private val newList: List<LessonUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}