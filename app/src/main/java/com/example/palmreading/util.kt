package com.example.palmreading

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun Number.pxToDp(): Dp {
    var cachedDensityScale: Float = 1f
    val scale = cachedDensityScale
    return (this.toFloat() * scale).dp
}

@Composable
fun Float.pxToSp(): TextUnit {
    val fontScale = LocalDensity.current.fontScale
    return (this / fontScale).sp
}

fun Float.pxToSp(density: Density): TextUnit {
    return with(density) { this@pxToSp.toSp() }
}