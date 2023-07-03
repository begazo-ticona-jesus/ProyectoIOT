package com.example.proyectoiot.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.proyectoiot.MQTTmanager
import com.example.proyectoiot.navigation.Routes
import com.example.proyectoiot.ui.composables.NavBar
import com.example.proyectoiot.ui.theme.GreenBlue
import com.example.proyectoiot.ui.theme.Pink
import java.util.UUID

@Composable
fun ScreenOptions(navController: NavController) {
    val mqttServerUri = "ssl://arkqsn31tskut-ats.iot.us-east-2.amazonaws.com:8883"
    val clientId = UUID.randomUUID()
    val topic = "topic_test"
    val qos = 0
    val applicationContext = LocalContext.current

    val responseSubcribe = remember {
        mutableStateOf("")
    }
    var mqttManager = MQTTmanager(mqttServerUri, clientId, topic, qos, applicationContext)
    mqttManager.connect(responseSubcribe)

    Column {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            text = "OPTIONS",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
        Box(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            Alignment.Center
        ){
            Column {
                Button(
                    onClick = {
                              mqttManager.publish("{'message': 'ENCENDER'}")
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                    ),
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(180.dp)
                        .background(
                            brush = Brush.horizontalGradient(listOf(GreenBlue, Color.LightGray, Pink)),
                            shape = RoundedCornerShape(16.dp)
                        )

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "ENCENDER",
                            fontSize = 15.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 10.dp),
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrow Icon",
                            tint = Color.White,

                            )
                    }
                }
                Button(
                    onClick = {
                        mqttManager.publish("{'message': 'APAGAR'}")
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                    ),
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(180.dp)
                        .background(
                            brush = Brush.horizontalGradient(listOf(GreenBlue, Color.LightGray, Pink)),
                            shape = RoundedCornerShape(16.dp)
                        )

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "APAGAR",
                            fontSize = 15.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 10.dp),
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrow Icon",
                            tint = Color.White,

                            )
                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.BottomCenter
        ) {
            NavBar(navController)
        }
    }
}