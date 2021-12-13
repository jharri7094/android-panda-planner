package edu.towson.cosc435.maddox.pandaplanner.navigation

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.login.Login
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.login.LoginViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup.Signup
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup.SignupViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.welcome.Welcome

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun PlannerLoginNavigation(app : Application, vm : LoginNavViewModel) {
    val navController = rememberNavController()
    val repo = vm.repo

    NavHost(navController = navController, startDestination = Routes.Welcome.route) {

        //Welcome page
        composable(Routes.Welcome.route){
            Welcome {
                navController.navigate(Routes.Login.route){
                    launchSingleTop = true
                }
            }
        }

        //Login page
        composable(Routes.Login.route)
        {
            val loginViewModel =  LoginViewModel(app, repo)
            Login(vm = loginViewModel,
                onLoginClick = { userId ->
                        repo.setUserId(userId)
                        navController.navigate(Routes.PostLoginNav.route) {
                            launchSingleTop = true
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
            val signupViewModel = SignupViewModel(app, repo)
            Signup(
                onSignupClick = {
                    navController.navigate(Routes.Login.route) {
                        launchSingleTop = true
                    }
                },
                onCancelClick = {
                    navController.popBackStack()
                },
                vm = signupViewModel
            )
        }

        //PostLoginNav to control nav with a scaffold
        composable(Routes.PostLoginNav.route){
            PostLoginNav(app, repo)
        }

    }
}