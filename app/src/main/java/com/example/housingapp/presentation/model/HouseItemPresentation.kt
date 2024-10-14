package com.example.housingapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HouseItemPresentation(
    val imageLink: String,
    val shortDescription: String,
    val longDescription: String,
    val costPerMonth: Int,
    val telephone: Int,
) : Parcelable