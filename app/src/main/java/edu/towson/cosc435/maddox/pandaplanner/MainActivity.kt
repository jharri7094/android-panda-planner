package edu.towson.cosc435.maddox.pandaplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome.Welcome

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PandaPlannerTheme {
                    Welcome()
            }
        }
    }
}
