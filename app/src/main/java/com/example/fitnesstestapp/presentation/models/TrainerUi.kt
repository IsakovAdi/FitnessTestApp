package com.example.fitnesstestapp.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TrainerUi(
    val trainerId: String,
    val trainerFullName: String,
    val trainerName: String,
    val trainerPosition: String,
    val imageUrl: String,
) : Parcelable