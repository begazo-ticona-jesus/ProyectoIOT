package com.example.proyectoiot.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.proyectoiot.ui.composables.NavBar

@Composable
fun ScreenAccount(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            text = "ACCOUNT",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.BottomCenter
        ) {
            NavBar(navController)
        }
    }

}