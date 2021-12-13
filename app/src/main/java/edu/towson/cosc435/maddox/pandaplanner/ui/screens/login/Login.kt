package edu.towson.cosc435.maddox.pandaplanner.ui.screens.login

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import edu.towson.cosc435.maddox.pandaplanner.R
import edu.towson.cosc435.maddox.pandaplanner.ui.components.UserEntryTextField
import edu.towson.cosc435.maddox.pandaplanner.ui.components.BigWelcome

@Composable
fun Login(vm: LoginViewModel,
          onLoginClick : (Long) -> Unit,
          onSignupClick : () -> Unit)
{
    if (vm.navigate.value && vm.userId.value!= null){
        vm.toggleNavigate()
        onLoginClick(vm.userId.value!!)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )  {

        val painter = rememberImagePainter(R.drawable.planning_panda)
        Image(modifier = Modifier.rotate(180F), painter = painter, contentDescription = null, alignment = Alignment.Center, contentScale = ContentScale.FillBounds)

        BigWelcome("Welcome! Please login below")
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        if(vm.showValidationText.value) {
            Text(
                text = "ERROR: Invalid login credentials. Check your username and password then try again.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        UserEntryTextField(fieldText = vm.username.value, setText = {s -> vm.setUsername(s)}, labelText = "Enter username:", visualTransformation = VisualTransformation.None)
        UserEntryTextField(fieldText = vm.password.value, setText = {s -> vm.setPassword(s)}, labelText = "Enter password:", visualTransformation = PasswordVisualTransformation())
        Row(modifier = Modifier.padding(10.dp)) {

            Button(onClick = {
                vm.validate()
            },
                modifier = Modifier.padding(horizontal = 15.dp)
                    .background(MaterialTheme.colors.secondary)){
                Text(text = "Login")
            }

            Button(onClick = {
                vm.setShowValidationText(false)
                onSignupClick() },
                modifier = Modifier.padding(horizontal = 15.dp)){
                Text(text = "Signup")
            }
        }
    }
}

