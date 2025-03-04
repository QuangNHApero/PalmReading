package com.example.palmreading.setting

import androidx.annotation.DrawableRes

enum class SettingAction {
    LANGUAGE,
    PRIVACY_POLICY,
    TERMS_OF_SERVICE
}


data class SettingItem(
    @DrawableRes val icon: Int,
    val name: String,
    val value: String? = null,
    val action: SettingAction
)
