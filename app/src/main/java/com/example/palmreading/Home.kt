package com.example.palmreading

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
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.palmreading.ui.theme.PalmReadingTheme
import com.example.palmreading.ui.theme.boldFont
import com.example.palmreading.ui.theme.mediumFont
import com.example.palmreading.ui.theme.sunshineFont


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    GradientBackgroundWithImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.pxToDp(), start = 24.pxToDp(), end = 24.pxToDp()),
            verticalArrangement = Arrangement.spacedBy(24.pxToDp()),
        ) {
            HomeHeader(
                modifier = Modifier
                    .width(380.pxToDp())
                    .height(80.pxToDp())
            )

            palmReadingItems.forEach { item ->
                HomeCardItem(
                    item, modifier = Modifier
                        .width(382.pxToDp())
                        .height(156.pxToDp())
                )
            }

        }
    }
}


@Composable
fun GradientBackgroundWithImage(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.img_home_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() // Phủ đúng kích thước Column
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


@Composable
fun HomeHeader(modifier: Modifier = Modifier, text: String = "Palm Reading App") {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.pxToDp())
    ) {
        Image(
            painter = painterResource(R.drawable.ic_home_logo),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxHeight()
        )
        Text(
            text = text,
            fontSize = 32f.pxToSp(),
            fontFamily = sunshineFont,
            color = Color(0xFFFFC457),
            modifier = Modifier
                .weight(1f)
        )

        SettingButton { /*TODO*/ }

    }
}


@Composable
fun SettingButton(onSettingClick: () -> Unit) {
    IconButton(onSettingClick) {
        Image(
            painter = painterResource(R.drawable.ic_home_setting),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(24.pxToDp())
        )
    }
}

@Composable
fun CardContent(item: HomeCardItemModel, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.padding(16.pxToDp()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.pxToDp())
                .clip(RoundedCornerShape(16.pxToDp()))
        )
        Spacer(modifier = Modifier.width(12.pxToDp()))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.title,
                fontSize = 18f.pxToSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = boldFont,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Text(
                text = item.description,
                fontSize = 12f.pxToSp(),
                fontFamily = mediumFont,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF848890)
            )
        }
    }
}

val palmReadingItems = listOf(
    HomeCardItemModel(
        title = "General Palm Reading",
        description = "Discover the entire palm line now!",
        imageResId = R.drawable.ic_home_general,
        onCardClick = {}
    ),
    HomeCardItemModel(
        title = "Daily Palm Insights",
        description = "Daily predictions from your palm!",
        imageResId = R.drawable.ic_home_daily,
        onCardClick = {}
    ),
    HomeCardItemModel(
        title = "Love & Relationship Scan",
        description = "Palm lines can reveal the level of compatibility between you and that person.",
        imageResId = R.drawable.ic_home_love,
        onCardClick = {}
    )
)

@Preview(showBackground = true, widthDp = 430)
@Composable
fun HomeShow() {
    PalmReadingTheme {
        HomeScreen()
    }
}