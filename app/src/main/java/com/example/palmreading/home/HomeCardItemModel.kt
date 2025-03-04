package com.example.palmreading.home

import androidx.annotation.DrawableRes
import com.example.palmreading.base.CardItemModel

data class HomeCardItemModel(
    override val title: String,
    override val description: String,
    @DrawableRes override val imageResId: Int
) : CardItemModel
