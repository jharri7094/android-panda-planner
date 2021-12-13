package edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import edu.towson.cosc435.maddox.pandaplanner.R
import edu.towson.cosc435.maddox.pandaplanner.ui.components.Header

@Composable
fun Welcome(onClick : ()->Unit){
    val vm : WelcomeViewModel = viewModel()
    val randomMessage1 = vm.randomMessage1.value
    val randomMessage2 = vm.randomMessage2.value

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface)
        .clickable { onClick() },
        verticalArrangement = Arrangement.SpaceBetween
        ) {
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            //Welcome message
            Header("Welcome to Panda Planner!")
        }
        Spacer(modifier = Modifier.padding(15.dp))
            //Column for random joke 1
        Row(modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.Center) {
                Text(text = randomMessage1)
            }
        Spacer(modifier = Modifier.padding(15.dp))
            //Column for random joke 2
        Row(modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.Center) {
                Text(text = randomMessage2)
            }
        Column(modifier = Modifier.fillMaxSize().padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            val painter = rememberImagePainter(R.drawable.planning_panda)
            Image(painter = painter, contentDescription = null, alignment = Alignment.Center, contentScale = ContentScale.Fit)
            Text(text = "Tap the screen to log in")
        }
    }
}


