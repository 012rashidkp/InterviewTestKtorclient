package com.Test.interviewtest.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Test.interviewtest.R
import com.Test.interviewtest.navigation.Screens
import com.Test.interviewtest.ui.theme.popins_medium
import com.Test.interviewtest.ui.theme.tealcolor
import com.Test.interviewtest.ui.theme.whitecolor
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SplashScreen(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(whitecolor),
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.movie_app))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Movie App",
                fontSize = 21.sp,
                color = tealcolor,
                fontFamily = popins_medium,
                fontWeight = FontWeight.Bold

            )
        }

        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            navController.popBackStack()
            navController.navigate(Screens.Home.route)
        }
    }
}










