package com.example.palmreading.setting

import androidx.lifecycle.ViewModel
import com.example.palmreading.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        SettingUIState(
            items =
            listOf(
                SettingCategory(
                    title = "General",
                    items = listOf(
                        SettingItem(
                            icon = R.drawable.ic_language,
                            name = "Language",
                            value = "English",
                            SettingAction.LANGUAGE
                        )
                    )
                ),
                SettingCategory(
                    title = "About",
                    items = listOf(
                        SettingItem(
                            icon = R.drawable.ic_privacy,
                            name = "Privacy Policy",
                            value = null,
                            SettingAction.PRIVACY_POLICY
                        ),
                        SettingItem(
                            icon = R.drawable.ic_terms,
                            name = "Terms of Service",
                            value = null,
                            SettingAction.TERMS_OF_SERVICE
                        )
                    )
                )
            )
        )
    )

    val uiState: StateFlow<SettingUIState> = _uiState.asStateFlow()
}