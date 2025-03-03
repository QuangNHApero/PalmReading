package com.example.palmreading

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.palmreading.ui.theme.PalmReadingTheme


@Composable
fun SettingScreen(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .background(Color(0xFF13111F))
            .padding(top = 45.pxToDp(), start = 24.pxToDp(), end = 24.pxToDp())
    ) {
        TopSettingAppBar {  }
    }
}

@Composable
fun TopSettingAppBar(onBackClick: () ->Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onBackClick) {
            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.size(28.pxToDp())
            )
        }
        Text(
            text = "Setting"
        )
    }
}

@Preview(showBackground = true, widthDp = 430, heightDp = 900)
@Composable
fun SettingShow() {
    PalmReadingTheme {
        SettingScreen(modifier = Modifier.fillMaxSize())
    }
}