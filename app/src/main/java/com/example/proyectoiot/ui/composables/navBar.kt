package com.example.proyectoiot.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectoiot.R
import com.example.proyectoiot.ui.theme.Darkgreen
import com.example.proyectoiot.ui.theme.GreenBlue

@Preview
@Composable
fun NavBar(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(GreenBlue),
        Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(modifier = Modifier
                .size(90.dp, 70.dp)
                .clickable {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Darkgreen,
                        painter = painterResource(R.drawable.baseline_home_24),
                        contentDescription = "home",
                        modifier = Modifier.size(45.dp)
                    )
                    Text(text = "Home", color = Darkgreen)
                }
            }
            Box(modifier = Modifier
                .size(90.dp, 70.dp)
                .clickable {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Darkgreen,
                        painter = painterResource(R.drawable.baseline_window_24),
                        contentDescription = "options",
                        modifier = Modifier.size(45.dp)
                    )
                    Text(text = "Options", color = Darkgreen)
                }
            }
            Box(modifier = Modifier
                .size(90.dp, 70.dp)
                .clickable {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Darkgreen,
                        painter = painterResource(R.drawable.baseline_playlist_add_check_24),
                        contentDescription = "registers",
                        modifier = Modifier.size(45.dp)
                    )
                    Text(text = "Registers", color = Darkgreen)
                }
            }
            Box(modifier = Modifier
                .size(90.dp, 70.dp)
                .clickable {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Darkgreen,
                        painter = painterResource(R.drawable.baseline_person_24),
                        contentDescription = "account",
                        modifier = Modifier.size(45.dp)
                    )
                    Text(text = "Account", color = Darkgreen)
                }
            }
        }
    }
}