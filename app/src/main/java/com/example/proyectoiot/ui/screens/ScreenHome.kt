package com.example.proyectoiot.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.core.graphics.rotationMatrix
import com.example.proyectoiot.ui.theme.Pink

@Composable
fun BarChart(data: List<Float>, maxValue: Float) {
    val maxHeight = 200.dp
    val barWidth = 30.dp

    Row {
        data.forEach { value ->
            val barHeight = (value / maxValue) * maxHeight
            Canvas(
                modifier = Modifier.size(barWidth, barHeight).padding(5.dp)
            ) {
                rotate(degrees = 180f, pivot = Offset(x = size.width/2, y = size.height/2)) {
                    drawRect(
                        color = Color.Blue,
                        size = size
                    )
                }
            }
        }
    }
}