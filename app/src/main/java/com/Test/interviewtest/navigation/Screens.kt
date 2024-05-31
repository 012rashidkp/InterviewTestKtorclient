package com.Test.interviewtest.navigation

import kotlinx.serialization.Serializable

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object Home : Screens("home_screen")
    object Detail:Screens("details_screen")
}

