package com.example.palmreading.history

 import androidx.lifecycle.ViewModel
 import com.example.palmreading.R
 import kotlinx.coroutines.flow.MutableStateFlow
 import kotlinx.coroutines.flow.StateFlow
 import kotlinx.coroutines.flow.asStateFlow

class HistoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        HistoryUIState(
            items = listOf(
                HistoryModel(
                    title = "General Palm Reading",
                    description = "Discover the entire palm line now!",
                    imageResId = R.drawable.ic_home_general
                ),
                HistoryModel(
                    title = "Daily Palm Insights",
                    description = "Daily predictions from your palm!",
                    imageResId = R.drawable.ic_home_daily
                ),
                HistoryModel(
                    title = "Love & Relationship Scan",
                    description = "Palm lines can reveal the level of compatibility between you and that person.",
                    imageResId = R.drawable.ic_home_love
                )
            )
        )
    )
    val uiState: StateFlow<HistoryUIState> = _uiState.asStateFlow()
}