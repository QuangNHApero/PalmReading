package com.example.palmreading.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.palmreading.R
import com.example.palmreading.pxToDp
import com.example.palmreading.ui.components.BaseCardItem
import com.example.palmreading.ui.theme.sunshineFont

@Composable
fun GradientBackgroundWithImage(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_home_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF000000).copy(alpha = 0.8f),
                            Color(0xFF260047).copy(alpha = 0.9f)
                        )
                    )
                )
        ) {
            content()
        }
    }
}

// Header with logo and settings button.
@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    onSettingClick: () -> Unit,
    text: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.pxToDp())
    ) {
        Image(
            painter = painterResource(R.drawable.ic_home_logo),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight()
        )
        Text(
            text = text,
            fontSize = 32.sp,
            fontFamily = sunshineFont,
            color = Color(0xFFFFC457),
            modifier = Modifier.weight(1f)
        )
        SettingButton(onSettingClick = onSettingClick)
    }
}

// Settings button.
@Composable
fun SettingButton(onSettingClick: () -> Unit) {
    IconButton(onClick = onSettingClick, modifier = Modifier.size(24.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_home_setting),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
/*
@Composable
fun HomeCardItem(
    item: HomeCardItemModel,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    isHistoryScreen: Boolean = true,
    onCloseClick: (() -> Unit)? = null,
    onSeeMoreClick: (() -> Unit)? = null
) {
    BaseCardItem(
        item = item,
        onItemClick = onItemClick,
        modifier = modifier,
        isHistoryScreen = isHistoryScreen,
        onCloseClick = onCloseClick,
        onSeeMoreClick = onSeeMoreClick
    )
}*/