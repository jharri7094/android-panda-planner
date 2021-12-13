package edu.towson.cosc435.maddox.pandaplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import edu.towson.cosc435.maddox.pandaplanner.navigation.PlannerLoginNavigation
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.surface) {
                PandaPlannerTheme {
                    PlannerLoginNavigation()
                }
            }
        }
    }
}
