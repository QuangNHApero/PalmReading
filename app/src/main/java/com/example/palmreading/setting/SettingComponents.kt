package com.example.palmreading.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.palmreading.R
import com.example.palmreading.pxToDp
import com.example.palmreading.pxToSp
import com.example.palmreading.ui.theme.boldFont

@Composable
fun TopSettingAppBar(onBackClick: () ->Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onBackClick, modifier = Modifier.size(28.pxToDp())) {
            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = null,
            )
        }
        Text(
            text = "Setting",
            color = Color.White,
            fontSize = 18f.pxToSp(),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(28.pxToDp()))
    }
}

@Composable
fun SettingCategoryCompose(settingCategory: SettingCategory){
    Column(
        verticalArrangement = Arrangement.spacedBy(24.pxToDp())
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = settingCategory.title,
                fontFamily = boldFont,
                fontSize = 14f.pxToSp(),
                color = Color(0xFF848890)
            )
            Spacer(modifier = Modifier.width(16.pxToDp()))
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color(0xFFEEEEEE),
                thickness = 1.pxToDp()
            )
        }
        settingCategory.items.forEach { item ->
            SettingsItem(item)
        }
    }
}


@Composable
fun SettingsItem(item: SettingItem){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(24.pxToDp())
        )
        Spacer(modifier = Modifier.width(20.pxToDp()))
        Text(
            text = item.name,
            fontFamily = boldFont,
            fontSize = 20f.pxToSp(),
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(20.pxToDp()))
        Image(
            painter = painterResource(R.drawable.ic_arrow_right),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(18.pxToDp())
        )
    }
}