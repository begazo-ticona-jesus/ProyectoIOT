package com.example.proyectoiot.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.core.graphics.rotationMatrix
import com.example.proyectoiot.ui.composables.NavBar
import com.example.proyectoiot.ui.theme.GreenBlue
import com.example.proyectoiot.ui.theme.Pink


@Preview
@Composable
fun ScreenHome(){

    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.BottomCenter
    ) {
        NavBar()
    }
}

@Composable
fun BarChart(data: List<Float>, maxValue: Float) {
    val maxHeight = 200.dp
    val barWidth = 30.dp

    Row {
        data.forEach { value ->
            val barHeight = (value / maxValue) * maxHeight
            Canvas(
                modifier = Modifier
                    .size(barWidth, barHeight)
                    .padding(5.dp)
            ) {
                    drawRect(
                        color = Color.Gray,
                        size = size
                    )

            }
        }
    }
}