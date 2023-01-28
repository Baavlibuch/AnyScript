package com.example.hindiletters.ui

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hindiletters.R
import com.example.hindiletters.canvas.CanvasDraw
import com.example.hindiletters.compoundLetters.CompoundLvl1
import com.example.hindiletters.compoundLetters.CompoundLvl2
import com.example.hindiletters.database.Dta
import com.example.hindiletters.database.FillData
import com.example.hindiletters.secondLevel.SecondScreen2
import com.example.hindiletters.ui.theme.HindiLettersTheme


val randomHindiLetter= generateRandomHindiLetter()
val randomHindiLetter1= generateRandomHindiLetter()


@Composable
fun Navigation() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
        composable(Screen.MainScreen.route){
            Screen(navController=navController)
        }
        composable(Screen.SecondScreen.route){
            Screen2(navController=navController)
        }
        composable(Screen.ThirdScreen.route){
            Screen3(navController = navController)
        }
        composable(Screen.FourthScreen.route){
            Screen4(navController = navController)
        }
        composable(Screen.FifthScreen.route){
            Screen5(navController = navController)
        }
        composable(Screen.Lvl2FirstScreen.route){
            SecondScreen2(navController = navController)
        }
        composable(Screen.DataSqlite.route){
            FillData(navController = navController)
        }
        composable(Screen.DataSqlite2.route){
           Dta(navController = navController)
        }
        composable(Screen.CompoundLvl1.route){
            CompoundLvl1(navController=navController)
        }
        composable(Screen.CompoundLvl2.route){
            CompoundLvl2(navController=navController)
        }
        composable(Screen.Canvas.route){
            CanvasDraw(navController=navController)
        }

    }
    
}

@Composable
fun Screen(navController: NavController) {
    val animationState = remember { mutableStateOf(false) }
    var visible by remember { mutableStateOf(false) }
    BoxWithConstraints(contentAlignment = Alignment.TopStart) {
        SnowFall(isRocketEnabled = animationState.value)
        Rocket(isRocketEnabled = animationState.value,
            maxWidth = maxWidth, maxHeight =maxHeight)
        FireCracker(isRocketEnabled = animationState.value,
            maxWidth = 125.dp, maxHeight = 900.dp)
        Row {

            Button(R.raw.sample)
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                AnsButton(animationState = animationState.value,
                    onToggleAnimationState =
                    {
                        if(!animationState.value) {
                            animationState.value = !animationState.value
                        }else{
                            visible = !visible
                            animationState.value = !animationState.value
                        }

                    }, "अ",Color.Green, )

                Spacer(modifier = Modifier.height(20.dp))
             BtnClr(text = randomHindiLetter)
              //  AnsButton1(animationState = animationState.value, color = Color(0xFF858182),"ऊ")
                   Spacer(modifier = Modifier.height(20.dp))
                BtnClr(text = randomHindiLetter1)
              //  AnsButton1(animationState = animationState.value, color = Color(0xFF858182),"इ")
                Spacer(modifier = Modifier.height(50.dp))

//                androidx.compose.material.Button(onClick = {
//                    navController.navigate("main_screen") },
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan,
//                    contentColor = Color.White)) {
//                    Text(text = "refresh options")
//                }
               // ToastBtn()
                //Gifts()
                  //  An()
               // InfiniteAnimation()
                Gifts(isGift = animationState.value,visible, R.drawable.giftbox)
                }

            }

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ProgressBar(navController = navController,"second_screen",0.1f,1)
        }
        }

    }

@Composable
fun Button(
    sound: Int
) {
    var player:MediaPlayer?= null
    val context = LocalContext.current
    IconButton(onClick = {
            try{
                val soundUri = Uri.parse("android.resource://com.example.hindiletters/"+
                sound)
                    player =MediaPlayer.create(context,soundUri)
                    player?.isLooping= false
                    player?.start()
            }catch(e:java.lang.Exception) {
                e.printStackTrace()
            }
    },
        modifier = Modifier.padding(top = 120.dp,
        start = 20.dp),
        enabled = true
        ) {
        Icon(imageVector = Icons.Filled.Person, contentDescription =null,
        modifier = Modifier
            .width(200.dp)
            .size(70.dp),
            )
    }
}

@Composable
fun SnowFall(isRocketEnabled: Boolean) {
    if (isRocketEnabled){
        Box(modifier = Modifier
            .fillMaxSize()
            .snowfall()){
            Card() {
                Text(text = "")
            }
        }
    }


}

@Composable
fun Rocket(
    isRocketEnabled:Boolean,
    maxWidth:Dp,
    maxHeight:Dp
) {
    val resource:Painter
    val modifier:Modifier
    val rocketSize=200.dp
    if(!isRocketEnabled){
        resource= painterResource(id = R.drawable.whitebg2)
        modifier=Modifier.offset(
            y=maxHeight-rocketSize
        )
    }else{
        val infiniteTransition = rememberInfiniteTransition()
        val engineState = infiniteTransition.animateFloat(initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing= LinearEasing
                )
            )
        )
        val positionState= infiniteTransition.animateFloat(initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        )
        if(engineState.value <=0.5f){
            resource= painterResource(id = R.drawable.rocket1)
        }else{
            resource= painterResource(id = R.drawable.rocket2)
        }
        modifier=Modifier.offset(
            x= (maxWidth-rocketSize)*positionState.value,
            y=(maxHeight-rocketSize)-((maxHeight-rocketSize)*positionState.value)
        )
    }
    Image(painter = resource, contentDescription ="A Rocket",
        modifier = modifier
            .width(rocketSize)
            .height(rocketSize)
        )
}

@Composable
fun AnsButton(
    animationState:Boolean,
    onToggleAnimationState:()->Unit,
    text:String,
    color: Color
) {
    Row(modifier = Modifier
        .padding(12.dp),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically) {
        if(animationState){
            Button(
                onClick =onToggleAnimationState   ,
                colors = ButtonDefaults.buttonColors(backgroundColor = color,
                contentColor = Color.White, )
                ) {
                Text(text = text, fontSize = 58.sp,
                    modifier = Modifier.width(60.dp),
                textAlign = TextAlign.Center)
            }
        }else{
            Button(
                onClick = onToggleAnimationState,
            ) {
                Text(text = text,fontSize = 58.sp,
                modifier = Modifier.width(60.dp),
                    textAlign = TextAlign.Center)
            }
        }
    }
}


@Composable
fun FireCracker(
    isRocketEnabled:Boolean,
    maxWidth:Dp,
    maxHeight:Dp
) {
    val resource:Painter
    val modifier:Modifier
    val rocketSize=125.dp
    if(!isRocketEnabled){
        resource= painterResource(id = R.drawable.whitebg2)
        modifier=Modifier.offset(
            y=maxHeight-rocketSize
        )
    }else{
        val infiniteTransition = rememberInfiniteTransition()
        val engineState = infiniteTransition.animateFloat(initialValue = 0.4f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing= LinearOutSlowInEasing
                )
            )
        )
        val positionState= infiniteTransition.animateFloat(initialValue = 0.4f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        )
        if(engineState.value <=0.5f){
            resource= painterResource(id = R.drawable.firecracker__)
        }else{
            resource= painterResource(id = R.drawable.firecracker__)
        }
        modifier=Modifier.offset(
            x= (maxWidth-rocketSize)*positionState.value,
            y=(maxHeight-rocketSize)-((maxHeight-rocketSize)*positionState.value)
        )
    }
    Image(painter = resource, contentDescription ="A Rocket",
        modifier = modifier
            .width(rocketSize)
            .height(rocketSize)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HindiLettersTheme {
       // Screen(navController = )
    }
}