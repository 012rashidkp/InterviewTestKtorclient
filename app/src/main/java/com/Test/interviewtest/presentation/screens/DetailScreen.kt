package com.Test.interviewtest.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Test.interviewtest.presentation.components.GeneresRow
import com.Test.interviewtest.ui.theme.black
import com.Test.interviewtest.ui.theme.greyblack
import com.Test.interviewtest.ui.theme.greycolor
import com.Test.interviewtest.ui.theme.popins_medium
import com.Test.interviewtest.ui.theme.popins_regular
import com.Test.interviewtest.ui.theme.whitecolor
import com.Test.interviewtest.utility.DataStore
import com.Test.interviewtest.utility.Movie_items
import com.Test.interviewtest.utility.TinyDB

@Composable
fun DetailScreen(navController: NavController){
val context= LocalContext.current
    val dataStore = DataStore(context)
    val title by dataStore.getTitle.collectAsState(initial = null)
    val desc by dataStore.getdesc.collectAsState(initial = null)
    val release by dataStore.getrelease.collectAsState(initial=null)
    val posterurl by dataStore.getposterurl.collectAsState(initial=null)
    val rating by dataStore.getrating.collectAsState(initial=null)
    val generes by dataStore.getgeneres.collectAsState(initial = null)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(whitecolor),
        contentAlignment = Alignment.Center
    ) {
     Column(
         modifier = Modifier
             .padding(16.dp)
             .fillMaxWidth()
     ) {
    Text(
        text ="${title}",
        fontSize = 18.sp,
        color = black,
        fontFamily = popins_medium,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()



    )
         Spacer(modifier = Modifier.height(20.dp))

            Text(
                text ="Description : ",
                fontSize = 16.sp,
                color = greyblack,
                fontFamily = popins_regular
            )
            Text(
                text ="${desc}",
                fontSize = 16.sp,
                color = black,
                fontFamily = popins_regular
            )
         Spacer(modifier = Modifier.height(20.dp))
         Text(
             text ="Release : ",
             fontSize = 16.sp,
             color = greyblack,
             fontFamily = popins_regular
         )
         Text(
             text ="${release}",
             fontSize = 16.sp,
             color = black,
             fontFamily = popins_regular
         )
         Spacer(modifier = Modifier.height(20.dp))
         Text(
             text ="posterurl : ",
             fontSize = 16.sp,
             color = greyblack,
             fontFamily = popins_regular
         )
         Text(
             text ="${posterurl}",
             fontSize = 16.sp,
             color = black,
             fontFamily = popins_regular
         )
         Spacer(modifier = Modifier.height(20.dp))
         Text(
             text ="Rating : ",
             fontSize = 16.sp,
             color = greyblack,
             fontFamily = popins_regular
         )
         Text(
             text ="${rating}",
             fontSize = 16.sp,
             color = black,
             fontFamily = popins_regular
         )
         Spacer(modifier = Modifier.height(20.dp))
         Text(
             text ="Genres : ",
             fontSize = 16.sp,
             color = greyblack,
             fontFamily = popins_regular
         )
         GeneresRow(generes = generes)
         




     }

     }


}