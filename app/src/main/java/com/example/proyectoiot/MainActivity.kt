package com.example.proyectoiot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectoiot.ui.screens.BarChart
import com.example.proyectoiot.ui.screens.ScreenUserLogin
import com.example.proyectoiot.ui.screens.ScreenUserRegister
import com.example.proyectoiot.ui.theme.ProyectoIOTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoIOTTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(R.drawable.bg_iot),
                        contentDescription = "Background",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                    BarChartDiagram()
                    //ScreenUserLogin()
                    //ScreenUserRegister()
                }
            }
        }
    }
}

@Preview
@Composable
fun BarChartDiagram() {
    val data = listOf(10f, 20f, 15f, 30f, 25f)
    val maxValue = data.maxOrNull() ?: 0f
    Box(
        modifier = Modifier.padding(20.dp),
        Alignment.TopCenter
    ) {
        BarChart(data = data, maxValue = maxValue)
    }
}
