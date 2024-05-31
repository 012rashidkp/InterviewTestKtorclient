package com.Test.interviewtest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Test.interviewtest.ui.theme.black
import com.Test.interviewtest.ui.theme.greylight
import com.Test.interviewtest.ui.theme.popins_regular
import com.Test.interviewtest.ui.theme.tealcolor
import com.Test.interviewtest.ui.theme.whitecolor

@Composable
fun GeneresRow(
    generes:List<String>?
){
    var selectedposition by remember { mutableStateOf(0) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(
            start = 5.dp,
            top = 5.dp,
            end = 5.dp,
            bottom = 5.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(generes?.size?:0) { index ->
            val datas= generes?.get(index)
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(if (selectedposition == index) tealcolor else greylight)
                    .clickable {
                        selectedposition = index

                    },

                ) {
                Text(
                    text = datas?:"",
                    fontSize = 16.sp,
                    color = if (selectedposition==index) whitecolor else black,
                    fontFamily = popins_regular,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)

                )


                  }


        }



    }

}