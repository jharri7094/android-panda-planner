package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddEventFAB(onClick: () -> Unit, modifier: Modifier = Modifier){
    FloatingActionButton(onClick = onClick, modifier = modifier) {
    }
}