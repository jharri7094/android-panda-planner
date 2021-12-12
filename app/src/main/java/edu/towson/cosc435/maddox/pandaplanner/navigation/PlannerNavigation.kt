package edu.towson.cosc435.maddox.pandaplanner.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.login.Login
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.login.LoginViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup.Signup
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup.SignupViewModel

@Composable
fun PlannerNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        //Login page
        composable(Routes.Login.route)
        {
            val loginViewModel: LoginViewModel = viewModel()
            Login(vm = loginViewModel,
                onLoginClick = { user_id ->
                    if (user_id != null) {
                        navController.navigate(Routes.Home.route) {
                            launchSingleTop = true
                        }
                    }
                },
                onSignupClick = {
                    navController.navigate(Routes.Signup.route) {
                        launchSingleTop = true
                    }
                })
        }

        //Signup page
        composable(Routes.Signup.route)
        {
            val signupViewModel: SignupViewModel = viewModel()
            Signup(
                onSignupClick = {
                    navController.navigate(Routes.Login.route) {
                        launchSingleTop = true
                    }
                },
                onCancelClick = {
                    navController.navigate(Routes.Login.route) {
                        launchSingleTop = true
                    }
                },
                vm = signupViewModel
            )
        }
    }
}