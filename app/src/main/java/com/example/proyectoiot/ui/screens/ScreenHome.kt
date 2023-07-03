package com.example.proyectoiot.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.proyectoiot.ui.composables.NavBar


@Composable
fun ScreenHome(navController: NavController) {
    val data = listOf(10f, 20f, 15f, 30f, 25f)
    val maxValue = data.maxOrNull() ?: 0f
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            Alignment.TopCenter
        ){
            BarChart(data, maxValue)
        }
        Box(
            modifier = Modifier.fillMaxHeight(),
            Alignment.BottomCenter
        ) {
            NavBar(navController)
        }
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