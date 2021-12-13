package edu.towson.cosc435.maddox.pandaplanner.navigation

sealed class Routes (val route: String){
    object Welcome : Routes("Welcome")
    object Home : Routes("Home")
    object Login : Routes("Login")
    object Signup : Routes("Signup")
    object AddEvent : Routes("AddEvent")
    object Log : Routes("Log")
    object PostLoginNav : Routes("PostLoginNav")
}