package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddEventFAB(onClick: () -> Unit, modifier: Modifier = Modifier){
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.onSecondary
    ){
        Icon(Icons.Filled.Add, contentDescription = "Click to add an event")
    }
}