package edu.towson.cosc435.maddox.pandaplanner.ui.screens.home

import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddTodoFloatingActionButton(onClick: () -> Unit, modifier: Modifier = Modifier){
    FloatingActionButton(onClick = onClick, modifier = modifier) {
    }
}