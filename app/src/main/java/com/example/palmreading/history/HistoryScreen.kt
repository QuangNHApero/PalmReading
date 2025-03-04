package com.example.palmreading.history

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.palmreading.R
import com.example.palmreading.components.BackButton
import com.example.palmreading.home.GradientBackgroundWithImage
import com.example.palmreading.pxToDp
import com.example.palmreading.components.BaseCardItem

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = viewModel(),
    onBackClick: () -> Unit,
    onCameraClick: () -> Unit,
    onUploadClick: () -> Unit,
    onItemClick: (HistoryModel) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HistoryContent(
        modifier = modifier,
        items = uiState.items,
        onItemClick = onItemClick,
        onBackClick = onBackClick,
        onCameraClick = onCameraClick,
        onUploadClick = onUploadClick
    )
}

@Composable
fun HistoryContent(
    modifier: Modifier = Modifier,
    items: List<HistoryModel>,
    onItemClick: (HistoryModel) -> Unit,
    onBackClick: () -> Unit,
    onCameraClick: () -> Unit,
    onUploadClick: () -> Unit
) {
    GradientBackgroundWithImage {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 50.pxToDp(), start = 24 .pxToDp(), end = 24.pxToDp()),
            verticalArrangement = Arrangement.spacedBy(24.pxToDp())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(onBackClick)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.ic_open_camera),
                        contentDescription = "Open Camera",
                        modifier = Modifier
                            .size(68.pxToDp())
                            .clickable { onCameraClick() }
                    )
                    Spacer(modifier = Modifier.size(12.pxToDp()))
                    Text(text = "Open Camera", color = Color.White)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.ic_upload_image),
                        contentDescription = "Upload Image",
                        modifier = Modifier
                            .size(68.pxToDp())
                            .clickable { onUploadClick() }
                    )
                    Spacer(modifier = Modifier.size(12.pxToDp()))
                    Text(text = "Upload Image", color = Color.White)
                }
            }

            Text(
                text = "History of Palm Reading",
                fontSize = 18.sp,
                color = Color.Yellow,
            )

            items.forEach { item ->
                BaseCardItem(
                    item = item,
                    onItemClick = { onItemClick(item) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(156.pxToDp()),
                    isHistoryScreen = true,
                    onCloseClick = {  },
                    onSeeMoreClick = {  }
                )
            }

        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun AA() {
    HistoryScreen(modifier = Modifier, HistoryViewModel(), {}, {}, {}, {})
}