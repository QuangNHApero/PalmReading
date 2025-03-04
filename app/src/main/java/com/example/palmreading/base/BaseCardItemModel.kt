package com.example.palmreading.base

import androidx.annotation.DrawableRes

interface CardItemModel {
    val title: String
    val description: String
    @get:DrawableRes
    val imageResId: Int
}