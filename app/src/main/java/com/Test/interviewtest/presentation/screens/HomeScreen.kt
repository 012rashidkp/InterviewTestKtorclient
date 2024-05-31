package com.Test.interviewtest.presentation.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.Test.interviewtest.R
import com.Test.interviewtest.domain.model.FetchMovieList
import com.Test.interviewtest.domain.model.Movieslist
import com.Test.interviewtest.navigation.Screens
import com.Test.interviewtest.presentation.components.ShimmerLoading


import com.Test.interviewtest.presentation.viewModel.MovieViewModel
import com.Test.interviewtest.ui.theme.black
import com.Test.interviewtest.ui.theme.newgreycolor
import com.Test.interviewtest.ui.theme.popins_medium
import com.Test.interviewtest.ui.theme.popins_regular
import com.Test.interviewtest.ui.theme.tealcolor

import com.Test.interviewtest.ui.theme.whitecolor
import com.Test.interviewtest.utility.DataStore
import com.Test.interviewtest.utility.Movie_items
import com.Test.interviewtest.utility.Sucess
import com.Test.interviewtest.utility.TinyDB
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController){
    val movieViewModel = hiltViewModel<MovieViewModel>()
    val liststate = movieViewModel.state.value
    var isloading by remember { mutableStateOf(true) }
    var iserror by remember { mutableStateOf("") }

    val collapsedState = remember(liststate?.list) { liststate?.list?.map { true }?.toMutableStateList() }
val context= LocalContext.current
//if (liststate?.status== Sucess){
//    LaunchedEffect(key1 = context) {
//        delay(550)
//        isloading=false
//    }
//
//}

    LaunchedEffect(liststate) {
          delay(850)
          when(liststate?.status){
              Sucess->{
                  isloading=false
              }
              else->{
                  iserror="Something Went wrong"
                  isloading=false
              }
          }
      }


      Box(
          modifier = Modifier
              .fillMaxSize()
              .background(whitecolor)
      ) {
       if (isloading){

       ShimmerLoading()

       }
        else{
          LazyColumn(
              modifier = Modifier
                  .fillMaxSize()
                  .padding(horizontal = 16.dp, vertical = 15.dp),
              verticalArrangement = Arrangement.spacedBy(10.dp),
              horizontalAlignment = Alignment.CenterHorizontally
          ) {
            liststate?.list?.forEachIndexed{index, datas ->
                val collapsed = collapsedState?.get(index)

                item(key = "trip_${index}") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Card(
                            colors = CardDefaults
                                .cardColors(newgreycolor),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .wrapContentHeight()
                                .animateContentSize(
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        easing = LinearOutSlowInEasing
                                    )
                                )
                                .clickable {
                                    //  collapsedState[index] = !collapsed
                                }

                        ) {

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                            ) {

                                Text(
                                    text =" ${datas?.genre}",
                                    color = black,
                                    fontSize = 18.sp,
                                    fontFamily = popins_medium,
                                    modifier = Modifier,
                                    textAlign = TextAlign.Left
                                )

                                Box(
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .wrapContentWidth()
                                        .padding(start = 10.dp)
                                        .align(Alignment.CenterVertically)
                                        .border(
                                            width = 2.dp,
                                            color = tealcolor,
                                            shape = CircleShape
                                        ),
                                ) {
//arrow
                                    AsyncImage(
                                        model =if (collapsed?:false) R.drawable.down_arrow_icon else R.drawable.up_arrow_icon ,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .height(28.dp)
                                            .width(28.dp)
                                            .clickable {
                                                collapsedState?.set(index, !collapsed!!)


                                            }
                                          )


                                }





                            }







                         }

                        Spacer(modifier = Modifier.height(10.dp))
//

                        if (!collapsed!!){
                            MovieTableHeader()
                        }



                    }

                }

                if (!collapsed!!){
                    items(items = datas?.movieslist!!){carditems->
                        MovieCard(
                            list = carditems!!,
                            navController = navController

                        )
                    }


                }




            }

          }







       }



      }


}

@Composable
fun MovieTableHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text ="Title",
            color = black,
            fontSize = 15.sp,
            fontFamily = popins_medium,
            modifier = Modifier
                .wrapContentWidth(),

            )

//        Text(
//            text ="Release",
//            color = black,
//            fontSize = 15.sp,
//            fontFamily = popins_medium,
//            modifier = Modifier
//                .wrapContentWidth(),
//
//            )
        Text(
            text ="Rating",
            color = black,
            fontSize = 15.sp,
            fontFamily = popins_medium,
            modifier = Modifier
                .wrapContentWidth(),

            )


    }






}

@Composable
fun MovieCard(
    list: Movieslist,
    navController: NavController
){
    val context= LocalContext.current
    val dataStore= DataStore(context)
    val scope= rememberCoroutineScope()

    Card(
        colors = CardDefaults
            .cardColors(newgreycolor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(12.dp))
            .wrapContentHeight()
            .clickable {
                scope.launch {
                    dataStore.Saveid(list.id)
                    dataStore.Savetitle(list.title)
                    dataStore.Savedesc(list.desc)
                    dataStore.Saverelease(list.release)
                    dataStore.Saveposterurl(list.posterurl)
                    dataStore.Saverating(list.rating)
                    dataStore.Savegeneres(list.genre)
                }


                navController.navigate(Screens.Detail.route)


            }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 8.dp)
        ) {
            Text(
                text ="${list.title}",
                color = black,
                fontSize = 16.sp,
                fontFamily = popins_regular,
                modifier = Modifier
                    .wrapContentWidth(),

                )

            Text(
                text ="${list.rating}",
                color = black,
                fontSize = 16.sp,
                fontFamily = popins_regular,
                modifier = Modifier
                    .wrapContentWidth(),

                )
        }


    }




}