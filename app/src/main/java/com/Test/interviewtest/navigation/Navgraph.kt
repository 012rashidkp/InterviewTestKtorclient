package com.Test.interviewtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.Test.interviewtest.presentation.screens.HomeScreen
import com.Test.interviewtest.presentation.screens.SplashScreen
import com.Test.interviewtest.animation.EnterExitAnimation
import com.Test.interviewtest.presentation.screens.DetailScreen


@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
       EnterExitAnimation { SplashScreen(navController = navController) }
        }

        composable(route = Screens.Home.route) {
            EnterExitAnimation { HomeScreen(navController = navController) }

        }

        composable(route = Screens.Detail.route) {
            EnterExitAnimation { DetailScreen(navController = navController) }

        }



      }





    }