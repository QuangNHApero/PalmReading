package com.example.palmreading.home

import androidx.lifecycle.ViewModel
import com.example.palmreading.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeUIState(
            items = listOf(
                HomeCardItemModel(
                    title = "General Palm Reading",
                    description = "Discover the entire palm line now!",
                    imageResId = R.drawable.ic_home_general
                ),
                HomeCardItemModel(
                    title = "Daily Palm Insights",
                    description = "Daily predictions from your palm!",
                    imageResId = R.drawable.ic_home_daily
                ),
                HomeCardItemModel(
                    title = "Love & Relationship Scan",
                    description = "Palm lines can reveal the level of compatibility between you and that person.",
                    imageResId = R.drawable.ic_home_love
                )
            )
        )
    )
    val uiState: StateFlow<HomeUIState> = _uiState
}