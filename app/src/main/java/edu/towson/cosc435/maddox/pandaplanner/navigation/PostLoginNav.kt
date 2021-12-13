package edu.towson.cosc435.maddox.pandaplanner.navigation

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent.AddEvent
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent.AddEventViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.Home
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.home.HomeViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.log.LogViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.log.loadList

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun PostLoginNav(app : Application,
                repo : EventsRepository){
    val navController = rememberNavController()

    Scaffold(topBar = {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(
                onClick = { navController.popBackStack(route = Routes.Home.route, false, saveState = false)},
                modifier = Modifier.background(color = MaterialTheme.colors.secondary)
            ) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Click to navigate to the home screen",
                    tint = MaterialTheme.colors.onSecondary
                )
            }

            IconButton(
                onClick = { navController.popBackStack(route = Routes.Log.route, false, saveState = false)},
                modifier = Modifier.background(color = MaterialTheme.colors.secondary)
            ) {
                Icon(
                    Icons.Filled.List,
                    contentDescription = "Click to navigate to the event log",
                    tint = MaterialTheme.colors.onSecondary
                )
            }
        }
    }){
        val addEventViewModel = AddEventViewModel(app, repo)
        val homeViewModel = HomeViewModel(app, repo)
        val logViewModel = LogViewModel(app, repo)

        NavHost(navController = navController, startDestination = Routes.Home.route)
        {
            composable(Routes.Home.route){
                Home(homeViewModel, onFabClick = {
                    navController.navigate(Routes.AddEvent.route){
                        launchSingleTop = true
                    }
                })
            }

            composable(Routes.AddEvent.route){

                AddEvent(
                    onAddEvent = { event ->
                        homeViewModel.addEvent(event)
                    },
                    vm = addEventViewModel,
                    onCancel = { navController.popBackStack() }
                )
            }

            composable(Routes.Log.route){
                loadList(vm = logViewModel, onDelete = {idx -> logViewModel.onDelete(idx) }, onToggle = {idx -> logViewModel.onToggle(idx) })
            }
        }
    }

}
