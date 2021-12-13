package edu.towson.cosc435.maddox.pandaplanner.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.Home
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.HomeViewModel

@ExperimentalFoundationApi
@Composable
fun PostLoginNav(){
    val navController = rememberNavController()

    Scaffold(topBar = {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = { navController.navigate(Routes.Home.route){ launchSingleTop=true } }, modifier = Modifier.background(color = MaterialTheme.colors.secondary)) {
                Icon(Icons.Filled.Home, contentDescription = "Click to navigate to the home screen", tint = MaterialTheme.colors.onSecondary)
            }

            IconButton(onClick = { navController.navigate(Routes.Log.route){ launchSingleTop=true } }, modifier = Modifier.background(color = MaterialTheme.colors.secondary)) {
                Icon(Icons.Filled.Home, contentDescription = "Click to navigate to the event log", tint = MaterialTheme.colors.onSecondary)
            }
        }
    }){

        NavHost(navController = navController, startDestination = Routes.Home.route)
        {
            composable(Routes.Home.route){
                val homeViewModel : HomeViewModel = viewModel()
                Home(homeViewModel)
            }

            composable(Routes.AddEvent.route){

            }

            composable(Routes.Log.route){

            }
        }
    }

}
