package com.example.proyectoiot.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoiot.R
import com.example.proyectoiot.ui.theme.GreenBlue
import com.example.proyectoiot.ui.theme.Pink

@Preview
@Composable
fun ScreenUserRegister() {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confPass by remember { mutableStateOf("") }
    var passView by remember { mutableStateOf(false) }
    var confView by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),

            ) {
            Text(
                text = "CREACION DE CUENTA",
                fontSize = 22.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(height = 20.dp))

            OutlinedTextField(
                value = username,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.DarkGray,
                    backgroundColor = Color.White,
                    cursorColor = Color.DarkGray,
                    focusedLabelColor = Color.DarkGray,
                ),

                onValueChange = { username = it },
                label = { Text(
                    text = "Nombre de usuario",
                    color = Color.DarkGray,
                    fontSize = 17.sp,
                ) },
                modifier = Modifier.fillMaxWidth(),

                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person Icon",
                        tint = Color.DarkGray,
                    )
                }
            )

            OutlinedTextField(
                value = email,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.DarkGray,
                    backgroundColor = Color.White,
                    cursorColor = Color.DarkGray,
                    focusedLabelColor = Color.DarkGray,
                ),

                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(
                    text = "Correo electronico",
                    color = Color.DarkGray,
                    fontSize = 17.sp,
                ) },
                modifier = Modifier.fillMaxWidth(),

                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = Color.DarkGray,
                    )
                }
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.DarkGray,
                    backgroundColor = Color.White,
                    cursorColor = Color.DarkGray,
                    focusedLabelColor = Color.DarkGray,
                ),

                label = { Text(
                    text = "Contraseña",
                    color = Color.DarkGray,
                    fontSize = 17.sp,
                ) },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if (passView) R.drawable.ic_password_off else R.drawable.ic_password_eye),
                        contentDescription = "Eye Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.clickable { passView = !passView }
                    )
                },
                visualTransformation = if (passView) VisualTransformation.None
                else PasswordVisualTransformation(),
            )

            OutlinedTextField(
                value = confPass,
                onValueChange = { confPass = it },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.DarkGray,
                    backgroundColor = Color.White,
                    cursorColor = Color.DarkGray,
                    focusedLabelColor = Color.DarkGray,
                ),

                label = { Text(
                    text = "Confirmar contraseña",
                    color = Color.DarkGray,
                    fontSize = 17.sp,
                ) },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if (confView) R.drawable.ic_password_off else R.drawable.ic_password_eye),
                        contentDescription = "Eye Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.clickable { confView = !confView }
                    )
                },
                visualTransformation = if (confView) VisualTransformation.None
                else PasswordVisualTransformation(),
            )


            Spacer(modifier = Modifier.height(height = 30.dp))


            Button(
                onClick = {

                },

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                ),
                elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                modifier = Modifier
                    .align(Alignment.End)
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
                        text = "CREAR",
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showError) {
                Text(
                    text = "Por favor, complete todos los campos correctamente",
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    modifier = Modifier.padding(bottom = 30.dp, start = 30.dp, end = 30.dp)
                )
            }

            Row() {

                Text(
                    text = "¿Ya tienes una cuenta?",
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp)
                        .clickable {

                        },
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    text = "Ingresa",
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                )
            }
        }
    }
}

fun checkValues(username: String, password: String,  confPass: String, email: String): Boolean {
    if (username.isEmpty() || password.isEmpty() || confPass.isEmpty() || email.isEmpty()) {
        return false
    }
    if (password != confPass) {
        return false
    }
    return true
}
