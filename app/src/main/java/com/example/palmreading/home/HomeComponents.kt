package com.example.palmreading.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.palmreading.R
import com.example.palmreading.ui.theme.boldFont
import com.example.palmreading.ui.theme.mediumFont
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
        horizontalArrangement = Arrangement.spacedBy(16.dp)
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
    IconButton(onClick = onSettingClick) {
        Image(
            painter = painterResource(R.drawable.ic_home_setting),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(24.dp)
        )
    }
}

// Card item composable with click callback.
@Composable
fun HomeCardItem(
    item: HomeCardItemModel,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(2.dp, Color(0xFFA17B58)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4A0A82).copy(alpha = 0.8f)),
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(24.dp),
                spotColor = Color(0xFFF17D12)
            )
            .clickable { onItemClick() }
    ) {
        CardContent(item = item)
    }
}

// Content inside the card: image and texts.
@Composable
fun CardContent(item: HomeCardItemModel, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = boldFont,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Text(
                text = item.description,
                fontSize = 12.sp,
                fontFamily = mediumFont,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF848890)
            )
        }
    }
}