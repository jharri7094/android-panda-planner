package edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.cosc435.maddox.pandaplanner.network.JokeFetcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private var _randomMessage1 by mutableStateOf("")
    val randomMessage1 = _randomMessage1

    private var _randomMessage2 by mutableStateOf("")
    val randomMessage2 = _randomMessage2

    init {
        val JF = JokeFetcher()
        viewModelScope.launch(context=Dispatchers.IO) {
            val Joke = JF.fetchJoke()
            _randomMessage1=Joke.setup
            _randomMessage2=Joke.punchline
        }
    }
}
