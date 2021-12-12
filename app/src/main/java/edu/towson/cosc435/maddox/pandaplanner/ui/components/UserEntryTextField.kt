package edu.towson.cosc435.maddox.pandaplanner.ui.components

import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.login.LoginViewModel

@Composable
fun UserEntryTextField(
    fieldText: String,
    labelText : String,
    setText: (String) -> Unit,
    visualTransformation: VisualTransformation
) {
        TextField(
            value = fieldText,
            onValueChange = { setText(it) },
            label = { Text(labelText) },
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
        )
}