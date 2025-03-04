package com.example.palmreading.home

import androidx.annotation.DrawableRes
import com.example.palmreading.base.BaseCardItemModel

data class HomeCardItemModel(
    override val title: String,
    override val description: String,
    @DrawableRes override val imageResId: Int
) : BaseCardItemModel()
