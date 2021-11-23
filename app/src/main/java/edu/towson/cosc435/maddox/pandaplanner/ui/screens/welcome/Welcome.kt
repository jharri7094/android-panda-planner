package edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Welcome(){
    val vm : WelcomeViewModel = viewModel()
    val randomMessage1 = vm.randomMessage1
    val randomMessage2 = vm.randomMessage2

    Column(modifier = Modifier.clickable { //TODO implement navigation
         },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        //Welcome message
        Text(text = "Welcome to Panda Planner!")

        Row() {
            //Column for random message 1
            Column() {
                Text(text = randomMessage1)
            }
            //Column for random message 2
            Column() {
                Text(text = randomMessage2)
            }
        }
    }
}
//TODO apply our color theme
//TODO implement random dad joke api


