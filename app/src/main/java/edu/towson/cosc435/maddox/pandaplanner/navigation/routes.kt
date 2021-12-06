package edu.towson.cosc435.maddox.pandaplanner.navigation

sealed class Routes(val route: String){
    object Login: Routes("login")
    object Signup: Routes("signup")
    object Home: Routes("home")
    object AddEvent: Routes("addEvent")
    object Log: Routes("log")
}