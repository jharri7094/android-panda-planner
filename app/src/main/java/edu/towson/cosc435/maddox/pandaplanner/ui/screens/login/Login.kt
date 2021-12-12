package edu.towson.cosc435.maddox.pandaplanner.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import edu.towson.cosc435.maddox.pandaplanner.ui.components.BigWelcome

@Composable
fun Login(vm: LoginViewModel,
          onLoginClick : (Int) -> Unit,
          onSignupClick : () -> Unit){

    vm.setUsername("")
    vm.setPassword("")
    if (vm.navigate.value && vm.user_id.value!= null){
        vm.toggleNavigate()
        onLoginClick(vm.user_id.value!!)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )  {
        BigWelcome("Welcome! Please login below")
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        if(vm.showValidationText.value) {
            Text(
                text = "ERROR: Invalid login credentials. Check your username and password then try again.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        UsernameTextField(vm)
        PasswordTextField(vm)
        Row(modifier = Modifier.padding(10.dp)) {

            Button(onClick = {
                vm.validate()
            },
                modifier = Modifier.padding(horizontal = 15.dp)){
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


@Composable
fun UsernameTextField(vm: LoginViewModel) {

    TextField(
        value = vm.username.value,
        onValueChange = { vm.setUsername(it) },
        label = { Text("Enter username") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )
}

@Composable
fun PasswordTextField(vm: LoginViewModel) {

    TextField(
        value = vm.password.value,
        onValueChange = { vm.setPassword(it) },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )