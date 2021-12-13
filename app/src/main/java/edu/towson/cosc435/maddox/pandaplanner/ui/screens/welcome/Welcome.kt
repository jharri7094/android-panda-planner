package edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import edu.towson.cosc435.maddox.pandaplanner.R
import edu.towson.cosc435.maddox.pandaplanner.ui.components.BigWelcome

@Composable
fun Welcome(onClick : ()->Unit){
    val vm : WelcomeViewModel = viewModel()
    val randomMessage1 = vm.randomMessage1.value
    val randomMessage2 = vm.randomMessage2.value

    Column(modifier = Modifier
        .fillMaxSize()
        .clickable { onClick() },
        ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            //Welcome message
            BigWelcome("Welcome to Panda Planner!")
        }
            //Column for random joke 1
        Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = randomMessage1)
                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
            }
            //Column for random joke 2
        Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = randomMessage2)
                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
            }
        Row() {
                val painter = rememberImagePainter(R.drawable.planning_panda)
                Image(painter = painter, contentDescription = null, alignment = Alignment.Center)
            }
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Tap the screen to log in")
        }
    }
}
//TODO apply our color theme


