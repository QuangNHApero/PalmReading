package com.example.palmreading.history

import androidx.annotation.DrawableRes

data class HistoryModel(
    val name: String,
    val description: String,
    @DrawableRes val imageResId: Int
)