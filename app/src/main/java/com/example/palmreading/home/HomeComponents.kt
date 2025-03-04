package com.example.palmreading.home

import android.graphics.BlurMaskFilter
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
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.palmreading.R
import com.example.palmreading.pxToDp
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

@Composable

fun CardContent(
    item: HomeCardItemModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.pxToDp())
                .clip(RoundedCornerShape(16.pxToDp()))
        )
        Spacer(modifier = Modifier.width(12.pxToDp()))
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
                color = Color(0xFF848890),
                maxLines = 3
            )
        }
    }
}

@Composable
fun HomeCardItem(
    item: HomeCardItemModel,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    isHistoryScreen: Boolean = true,
    onCloseClick: (() -> Unit)? = null,
    onSeeMoreClick: (() -> Unit)? = null
) {
    Card(
        shape = RoundedCornerShape(24.pxToDp()),
        border = BorderStroke(2.pxToDp(), Color(0xFFA17B58)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4A0A82).copy(alpha = 0.8f)),
        modifier = modifier
            .fillMaxWidth()
            .customShadow(
                color = Color(0xFFF17D12).copy(alpha = 0.5f),
                offsetX = 2.pxToDp(),
                offsetY = 6.pxToDp(),
                blurRadius = 8.pxToDp(),
                roundedRadius = 24.pxToDp()
            )
            .clickable { onItemClick() }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.pxToDp())
        ) {

            CardContent(
                item = item,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
            )

            // If its in the history screen, add a close and see more button
            if (isHistoryScreen) {
                IconButton(
                    onClick = { onCloseClick?.invoke() },
                    modifier = Modifier
                        .size(24.pxToDp())
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_close),
                        modifier = Modifier.size(24.pxToDp()),
                        contentDescription = null
                    )
                }

                Text(
                    text = "See More →",
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clickable { onSeeMoreClick?.invoke() }
                        .padding(top = 8.pxToDp())
                )
            }

        }
    }
}

fun Modifier.customShadow(
    color: Color = Color(0x1A000000),
    offsetX: Dp = 5.pxToDp(),
    offsetY: Dp = 4.pxToDp(),
    blurRadius: Dp = 8.pxToDp(),
    roundedRadius: Dp = 24.pxToDp()
) = this.drawBehind {
    drawIntoCanvas { canvas ->
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        val spreadPixel = blurRadius.toPx()
        val leftPixel = offsetX.toPx()
        val topPixel = offsetY.toPx()
        val rightPixel = size.width + spreadPixel
        val bottomPixel = size.height + spreadPixel

        frameworkPaint.color = color.toArgb()
        frameworkPaint.maskFilter = BlurMaskFilter(
            blurRadius.toPx(),
            BlurMaskFilter.Blur.NORMAL
        )

        canvas.drawRoundRect(
            left = leftPixel,
            top = topPixel,
            right = rightPixel,
            bottom = bottomPixel,
            radiusX = roundedRadius.toPx(),
            radiusY = roundedRadius.toPx(),
            paint = paint
        )
    }
}