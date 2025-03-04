package com.example.palmreading.home

import androidx.annotation.DrawableRes

data class HomeCardItemModel(
    val title: String,
    val description: String,
    @DrawableRes val imageResId: Int
)