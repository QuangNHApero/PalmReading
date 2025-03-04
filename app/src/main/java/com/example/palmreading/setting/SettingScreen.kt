package com.example.palmreading.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.palmreading.pxToDp
import com.example.palmreading.ui.theme.PalmReadingTheme

@Composable
fun SettingScreen(onBackClick: () -> Unit, viewModel: SettingViewModel = viewModel()){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SettingContent(
        items = uiState.items,
        onBackClick = onBackClick
    )
}

@Composable
fun SettingContent(items: List<SettingCategory>,
                   onBackClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF13111F))
            .padding(top = 45.pxToDp(), start = 24.pxToDp(), end = 24.pxToDp()),
        verticalArrangement = Arrangement.spacedBy(24.pxToDp())

    ) {
        TopSettingAppBar { onBackClick() }

        items.forEach { category ->
            SettingCategoryCompose(category)
        }
    }
}

@Preview(showBackground = true, widthDp = 430, heightDp = 900)
@Composable
fun SettingShow() {
    PalmReadingTheme {
        SettingScreen({})
    }
}