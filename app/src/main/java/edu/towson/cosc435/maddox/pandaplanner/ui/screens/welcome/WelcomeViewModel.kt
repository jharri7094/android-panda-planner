package edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.network.JokeFetcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeViewModel(app : Application) : AndroidViewModel(app) {
    private var _randomMessage1 : MutableState<String> = mutableStateOf("some setup")
    val randomMessage1 = _randomMessage1

    private var _randomMessage2 : MutableState<String> = mutableStateOf("some punchline")
    val randomMessage2 = _randomMessage2

    init {
        viewModelScope.launch(context=Dispatchers.IO) {
            loadJoke()
        }
    }

    private suspend fun loadJoke(){
        val jF = JokeFetcher()
        val joke = jF.fetchJoke()
        _randomMessage1.value=joke.joke
        _randomMessage2.value=joke.joke
    }
}
