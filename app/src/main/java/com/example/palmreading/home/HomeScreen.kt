package com.example.palmreading.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.palmreading.R
import com.example.palmreading.ui.theme.PalmReadingTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onItemClick: (HomeCardItemModel) -> Unit,
    onSettingClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeContent(
        modifier = modifier,
        items = uiState.items,
        onItemClick = onItemClick,
        onSettingClick = onSettingClick
    )
}

@Composable
fun HomeContent(
    items: List<HomeCardItemModel>,
    onItemClick: (HomeCardItemModel) -> Unit,
    onSettingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    GradientBackgroundWithImage {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 60.dp, start = 24.dp, end = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            HomeHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                onSettingClick = onSettingClick,
                text = "Palm Reading App"
            )
            items.forEach { item ->
                HomeCardItem(
                    item = item,
                    onItemClick = { onItemClick(item) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(156.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 430)
@Composable
fun HomeScreenPreview() {
    PalmReadingTheme {
        HomeContent(
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
            ),
            onItemClick = {},
            onSettingClick = {}
        )
    }
}