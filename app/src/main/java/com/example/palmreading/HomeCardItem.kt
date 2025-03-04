package com.example.palmreading

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color

@Composable
fun HomeCardItem(item: HomeCardItemModel, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(24.pxToDp()),
        border = BorderStroke(width = 2.pxToDp(), Color(0xFFA17B58)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4A0A82).copy(alpha = 0.8f)),
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = 20.pxToDp(),
                shape = RoundedCornerShape(24.pxToDp()),
                spotColor = Color(0xFFF17D12)
            )
            .clickable { item.onCardClick() }
    ) {
        CardContent(item)
    }
}