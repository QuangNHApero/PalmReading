package com.example.palmreading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.palmreading.home.HomeScreen


import com.example.palmreading.ui.theme.PalmReadingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PalmReadingTheme {
                HomeScreen(onItemClick = {}, onSettingClick = {})
            }
        }
    }
}

