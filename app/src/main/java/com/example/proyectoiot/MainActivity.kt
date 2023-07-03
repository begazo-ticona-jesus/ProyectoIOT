package com.example.proyectoiot

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoiot.navigation.Routes
import com.example.proyectoiot.ui.screens.ScreenAccount
import com.example.proyectoiot.ui.screens.ScreenHome
import com.example.proyectoiot.ui.screens.ScreenListRegisters
import com.example.proyectoiot.ui.screens.ScreenOptions
import com.example.proyectoiot.ui.screens.ScreenUserLogin
import com.example.proyectoiot.ui.screens.ScreenUserRegister
import com.example.proyectoiot.ui.theme.ProyectoIOTTheme
import java.util.UUID


class MainActivity : ComponentActivity() {
    private val mqttServerUri = "ssl://arkqsn31tskut-ats.iot.us-east-2.amazonaws.com:8883"
    private val clientId = UUID.randomUUID()
    private val topic = "topic_test"
    private val qos = 0
    private val applicationContext: Context = this
    private lateinit var mqttManager: MQTTmanager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setBackground()
            val responseSubcribe = remember {
                mutableStateOf("")
            }
            mqttManager = MQTTmanager(mqttServerUri, clientId, topic, qos, applicationContext)
            mqttManager.connect(responseSubcribe)
                    /*Button(onClick = {
                        mqttManager.publish("HasfdjkashfbkwaQHJBDFSDSL,I")
                        }
                    ) {
                        Text(text = "publicar")
                    }*/
            startApp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mqttManager.disconnect()
    }
}

@Composable
fun setBackground(){
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

    }
}
@Composable
fun startApp(){
    val navController = rememberNavController()
    NavHost(navController,
        startDestination = Routes.UserLogin.route
    ){
        composable(Routes.UserLogin.route){
            ScreenUserLogin(navController)
        }
        composable(Routes.UserRegister.route){
            ScreenUserRegister(navController)
        }
        composable(Routes.Home.route){
            ScreenHome(navController)
        }
        composable(Routes.Options.route){
            ScreenOptions(navController)
        }
        composable(Routes.ListRegisters.route){
            ScreenListRegisters(navController)
        }
        composable(Routes.Account.route){
            ScreenAccount(navController)
        }
    }
}

/*class MainActivity : ComponentActivity() {
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
                    //BarChartDiagram()
                    ScreenUserLogin()
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
        modifier = Modifier
            .padding(20.dp)
            .background(Pink),
        Alignment.TopCenter,
    ) {
        BarChart(data = data, maxValue = maxValue)
    }
}*/
