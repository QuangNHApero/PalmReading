package com.example.palmreading.base

import androidx.annotation.DrawableRes

abstract class BaseCardItemModel {
    abstract val title: String
    abstract val description: String
    @get:DrawableRes
    abstract val imageResId: Int
}