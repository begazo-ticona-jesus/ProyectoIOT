package com.example.proyectoiot.ui.screens

import BarChart
import BarchartInput
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val names = listOf("a","b","c","d","e")
    val maxValue = data.maxOrNull() ?: 0f
    var showDescription by remember {
        mutableStateOf(true)
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp,100.dp),
            Alignment.TopCenter
        ){
            BarChart(
                listOf(
                    BarchartInput(28,"Lunes", Color.DarkGray),
                    BarchartInput(15,"Martes", Color.Green),
                    BarchartInput(11,"Miercoles", Color.LightGray),
                    BarchartInput(7,"Jueves", Color.Cyan),
                    BarchartInput(14,"Viernes", Color.Magenta),
                    BarchartInput(9,"Sabado", Color.Red),
                    BarchartInput(21,"Domingo", Color.Yellow)
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                showDescription = showDescription
            )
        }
        Box(
            modifier = Modifier.fillMaxHeight(),
            Alignment.BottomCenter
        ) {
            NavBar(navController)
        }
    }
}

