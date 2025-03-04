package com.example.palmreading

import androidx.annotation.DrawableRes

data class HomeCardItemModel(
    val title: String,
    val description: String,
    @DrawableRes val imageResId: Int,
    val onCardClick: () -> Unit
)