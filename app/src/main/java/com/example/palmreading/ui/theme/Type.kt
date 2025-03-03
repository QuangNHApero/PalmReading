package com.example.palmreading.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.palmreading.R
import com.example.palmreading.pxToSp

val sunshineFont = FontFamily(
    Font(R.font.sunshiney, FontWeight.Bold)
)

val mediumFont = FontFamily(
    Font(R.font.svngilroymedium, FontWeight.Medium)
)

val boldFont = FontFamily(
    Font(R.font.svngilroybold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    labelLarge = TextStyle(
        fontFamily = sunshineFont,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)