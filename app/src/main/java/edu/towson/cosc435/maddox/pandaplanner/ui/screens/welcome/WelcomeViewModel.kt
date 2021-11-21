package edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private val _randomMessage1 by mutableStateOf("")
    val randomMessage1 = _randomMessage1

    private val _randomMessage2 by mutableStateOf("")
    val randomMessage2 = _randomMessage2

    init {
        viewModelScope.launch(context=Dispatchers.IO) { loadMessages() }
    }

    private suspend fun loadMessages(){
        viewModelScope.launch {
        //some function to get messages
        }
    }
}
//code for random dad joke api
//val client = OkHttpClient()
//
//val request = Request.Builder()
//    .url("https://dad-jokes.p.rapidapi.com/joke/search?term=cow")
//    .get()
//    .addHeader("x-rapidapi-host", "dad-jokes.p.rapidapi.com")
//    .addHeader("x-rapidapi-key", "SIGN-UP-FOR-KEY")
//    .build()
//
//val response = client.newCall(request).execute()