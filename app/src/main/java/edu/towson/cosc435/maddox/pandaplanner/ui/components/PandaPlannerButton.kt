package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun bambooBrownButton(onClick : ()->Unit,
                        text : String,
                        modifier: Modifier = Modifier
){
    Button(onClick = { onClick() }, modifier = modifier.background(MaterialTheme.colors.secondary)) {
        Text(text = text, color = MaterialTheme.colors.onSecondary, fontWeight = FontWeight.Medium)
    }
}