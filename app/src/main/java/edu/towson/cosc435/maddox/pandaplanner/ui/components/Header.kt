package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun Header(text :String){
    Text(text = text, fontSize = 30.sp)    
}