package com.Test.interviewtest.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.Test.interviewtest.R
import com.Test.interviewtest.ui.theme.buttongreycolor
import com.Test.interviewtest.ui.theme.greylight
import com.Test.interviewtest.ui.theme.tealcolor
import com.Test.interviewtest.ui.theme.whitecolor

@Preview
@Composable
fun ShimmerLoading(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(4){
            AnimatedShimmerEffect()
        }
    }
}




@Composable
fun AnimatedShimmerEffect(){
    val shimmercolors= listOf(
        buttongreycolor.copy(alpha = 0.6f),
        buttongreycolor.copy(alpha = 0.2f),
        buttongreycolor.copy(alpha = 0.6f)
    )
    val transition= rememberInfiniteTransition()
    val translateAnim=transition.animateFloat(
        initialValue = 0f,
        targetValue =1000f ,
        animationSpec = infiniteRepeatable(
            animation = tween(
                delayMillis = 1000,
                easing = FastOutSlowInEasing
            )
        ),
        label = ""
    )
    val brush= Brush.linearGradient(
        colors = shimmercolors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

 Cardplaceholder(brush = brush)
}
@Composable
fun Cardplaceholder(brush: Brush){

    Card(
        colors = CardDefaults
            .cardColors(whitecolor),
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


    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {

            Box(
                modifier = Modifier
                    .width(75.dp)
                    .height(11.dp)
                    .background(brush)
            )

            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(brush)
                    .border(
                        width = 2.dp,
                        color = greylight,
                        shape = CircleShape
                    )

            ) {
//arrow
                AsyncImage(
                    model = R.drawable.down_arrow_icon,
                    contentDescription = "",
                    modifier = Modifier
                        .height(28.dp)
                        .width(28.dp)
                        .background(brush)

                )

            }

        }



    }

}