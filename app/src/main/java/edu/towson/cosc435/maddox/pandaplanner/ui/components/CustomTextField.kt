package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.BambooBrown
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.textBrown
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.textGreen

@Composable
fun BigWelcome(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = BambooBrown, fontSize = 28.sp, modifier = Modifier.padding(20.dp))
    }
}

@Composable
fun SmallHeader(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = BambooBrown, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TimingHeader(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = textBrown, fontSize = 18.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun todoEvent(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = textBrown, fontSize = 16.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun Details(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = textBrown, fontSize = 12.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun genericText(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = textGreen, fontSize = 12.sp, modifier = Modifier.padding(8.dp))
    }
}