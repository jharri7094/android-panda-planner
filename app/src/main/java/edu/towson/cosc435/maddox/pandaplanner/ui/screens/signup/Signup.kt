package edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import edu.towson.cosc435.maddox.pandaplanner.R
import edu.towson.cosc435.maddox.pandaplanner.ui.components.UserEntryTextField

@Composable
fun Signup(vm: SignupViewModel,
           onCancelClick : () -> Unit,
           onSignupClick : () -> Unit)
{
    val ctx = LocalContext.current

    if (vm.valid.value){
        vm.toggleValid()
        Toast.makeText(ctx,"Signup successful", Toast.LENGTH_LONG ).show()
        onSignupClick()
        vm.clearErrors()
        vm.clearFields()
    }

    vm.checkForPasswordMatch()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)  {
        Text(text = "Welcome! Please signup below")
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        if(vm.showEmptyFieldsValidationText.value) {
            Text(
                text = "ERROR: Fields cannot be blank.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        if(vm.showMatchValidationText.value) {
            Text(
                text = "ERROR: Passwords do not match. Try retyping passwords.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        if(vm.showCopyValidationText.value) {
            Text(
                text = "ERROR: An account with that username already exists. Please pick a new one.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        UserEntryTextField(fieldText = vm.username.value, setText = {s -> vm.setUsername(s)}, labelText = "Enter username:", visualTransformation = VisualTransformation.None)
        UserEntryTextField(fieldText = vm.password.value, setText = {s -> vm.setPassword(s)}, labelText = "Enter password:", visualTransformation = PasswordVisualTransformation())
        UserEntryTextField(fieldText = vm.confirmPassword.value, setText = {s -> vm.setConfirmPassword(s)}, labelText = "Confirm password:", visualTransformation = PasswordVisualTransformation())

        val painter = rememberImagePainter(R.drawable.planning_panda)
        Image(painter = painter, contentDescription = null, alignment = Alignment.Center, contentScale = ContentScale.FillBounds)

        Row(modifier = Modifier.padding(10.dp)) {

            Button(onClick = {
                vm.validate()
            },
                modifier = Modifier.padding(horizontal = 15.dp)){
                Text(text = "Signup")
            }

            Button(onClick = { onCancelClick() },
                modifier = Modifier.padding(horizontal = 15.dp)){
                Text(text = "Return to login")
            }
        }
    }

}