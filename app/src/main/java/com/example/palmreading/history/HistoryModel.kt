package com.example.palmreading.history

import androidx.annotation.DrawableRes
import com.example.palmreading.base.BaseCardItemModel

data class HistoryModel(
    override val title: String,
    override val description: String,
    @DrawableRes override val imageResId: Int
) : BaseCardItemModel()