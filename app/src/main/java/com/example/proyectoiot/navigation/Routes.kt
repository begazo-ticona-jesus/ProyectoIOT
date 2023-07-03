package com.example.proyectoiot.navigation

sealed class Routes (val route: String) {
    object Home: Routes("home")
    object UserLogin: Routes("login")
    object UserRegister: Routes("register")
    object Options: Routes("options")
    object ListRegisters: Routes("list_registers")
    object Account: Routes("account")
}