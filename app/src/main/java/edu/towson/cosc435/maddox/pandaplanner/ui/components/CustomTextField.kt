package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme

@Composable
fun BigWelcome(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = MaterialTheme.colors.secondary, fontSize = 28.sp, modifier = Modifier.padding(20.dp))
    }
}

@Composable
fun SmallHeader(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = MaterialTheme.colors.secondary, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TimingHeader(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = MaterialTheme.colors.primaryVariant, fontSize = 18.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun TodoEvent(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = MaterialTheme.colors.primaryVariant, fontSize = 16.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun Details(Text: String) {
    PandaPlannerTheme {
        Text(text = Text, color = MaterialTheme.colors.primaryVariant, fontSize = 12.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun GenericText(Text: String, modifier: Modifier = Modifier, fontWeight : FontWeight = FontWeight.Normal) {
    PandaPlannerTheme {
        Text(text = Text, color = MaterialTheme.colors.primary, fontSize = 12.sp, modifier = modifier.padding(8.dp), fontWeight = fontWeight)
    }
}