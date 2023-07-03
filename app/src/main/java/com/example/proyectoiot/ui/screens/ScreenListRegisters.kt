package com.example.proyectoiot.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.proyectoiot.MQTTmanager
import com.example.proyectoiot.ui.composables.NavBar
import java.util.UUID

@Composable
fun ScreenListRegisters(navController: NavController) {
    val mqttServerUri = "ssl://arkqsn31tskut-ats.iot.us-east-2.amazonaws.com:8883"
    val clientId = UUID.randomUUID()
    val topic = "topic_lum"
    val qos = 0
    val applicationContext = LocalContext.current

    val responseSubcribe = remember {
        mutableStateOf("")
    }
    var mqttManager = MQTTmanager(mqttServerUri, clientId, topic, qos, applicationContext)
    mqttManager.connect(responseSubcribe)
    
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            text = "REGISTERS",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
        CustomCard(text = responseSubcribe.value)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.BottomCenter
    ) {
        NavBar(navController)
    }
}
@Composable
fun CustomCard(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 4.dp
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = text,
            style = TextStyle.Default
        )
    }
}