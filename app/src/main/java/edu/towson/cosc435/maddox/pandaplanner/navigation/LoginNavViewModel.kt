package edu.towson.cosc435.maddox.pandaplanner.navigation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository

class LoginNavViewModel(app : Application) : AndroidViewModel(app) {
    val repo : EventsRepository = EventsRepository(app)
}