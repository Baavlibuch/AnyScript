package com.example.hindiletters.ui

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hindiletters.R


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Gifts(isGift:Boolean,
          visible: Boolean,
          pic:Int
          ) {
    Column(modifier = Modifier
        .padding(10.dp)
        .snowfall()
    ,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(
            visible = visible,
            enter =
            slideInVertically(
                initialOffsetY = { 80 }
            ) + expandVertically(
                expandFrom = Alignment.Bottom
            ) + scaleIn(
                transformOrigin = TransformOrigin(0.5f, 0f)
            ) ,
            exit =    fadeOut() + shrinkVertically() + slideOutVertically()
        ) {
            Column(Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Column(verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.size(1020.dp)
                    .padding(top=10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                    An(pic)
                    InfiniteAnimation()
                 }
                }
        }
    }
}

@Composable
fun ProgressBar(navController: NavController,
                route:String,
                value:Float,
                level:Int
                ) {
    Row(verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 30.dp,
            top = 200.dp,
            end = 150.dp
        )) {
        val progress by remember { mutableStateOf(value) }
        val animatedProgress by animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row() {
                Text(text = "Score: ",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Level:${level} ",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(progress = animatedProgress,
            color =  Color(0xFF07B925),
            modifier = Modifier.height(12.dp))

            Spacer(Modifier.requiredHeight(8.dp))
            androidx.compose.material.Button(
                onClick = {
                   // if (progress < 1f) progress += 0.3f
                    navController.navigate(route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFB09EF1))
            ) {
                Text("Next que")
            }
        }
    }
    }

@Composable
fun InfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 90.0f,
        targetValue = 100.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 100,easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Image(
        painter = painterResource(R.drawable.letter),

        contentDescription = "heart",
        modifier = Modifier
            .size(heartSize.dp)
    )
}


@Composable
fun BtnClr(
    text: String,
           ) {
    var isVisible by remember {
        mutableStateOf(true)
    }
    val transition = updateTransition(targetState = isVisible, label = null)
    val color by transition.animateColor(transitionSpec = {
        tween(800) },
    label = "color",
    targetValueByState ={isVisible->
        if(isVisible) Color(0xFF6200EE) else Color(0xFF858182)
    }
    )
    var player: MediaPlayer?= null
    val context = LocalContext.current

    Row(modifier = Modifier) {
        androidx.compose.material.Button(onClick = { isVisible = !isVisible
            try{
                val soundUri = Uri.parse("android.resource://com.example.hindiletters/"+
                        R.raw.sample)
                player =MediaPlayer.create(context,soundUri)
                player?.isLooping= false
                player?.start()
            }catch(e:java.lang.Exception) {
                e.printStackTrace()
            } },
            colors = ButtonDefaults.buttonColors(backgroundColor = color)) {
            Text(text = text, fontSize = 58.sp,
                modifier = Modifier.width(60.dp),
                textAlign = TextAlign.Center)
        }
    }


}

@Composable
fun Congratulations() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 120.0f,
        targetValue = 300.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, delayMillis = 100,easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Image(
        painter = painterResource(R.drawable.congratulation),

        contentDescription = "heart",
        modifier = Modifier
            .size(heartSize.dp)
    )
}


@Composable
fun An(
    pic:Int
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.White,
        targetValue = Color.Unspecified,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(Modifier
        .size(100.dp)
        .clip(RoundedCornerShape(50.dp))
        .background(color)
        .padding(20.dp)
            ){
        Image(painter = painterResource(id = pic), contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {

}