package com.example.hindiletters.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hindiletters.R


val randomHindiLetter2= generateRandomHindiLetter()
val randomHindiLetter3= generateRandomHindiLetter()
@Composable
fun Screen3(navController: NavController) {
    val animationState = remember { mutableStateOf(false) }
    var visible by remember { mutableStateOf(false) }
    BoxWithConstraints(contentAlignment = Alignment.TopStart,) {
        SnowFall(isRocketEnabled = animationState.value)
        Rocket(isRocketEnabled = animationState.value,
            maxWidth = maxWidth, maxHeight =maxHeight)
//        Rocket(isRocketEnabled = animationState.value,
//            maxWidth = 650.dp, maxHeight = 900.dp)
        FireCracker(isRocketEnabled = animationState.value,
            maxWidth = 125.dp, maxHeight = 900.dp)

        Row {
            Button((R.raw.sample))
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                BtnClr(text = randomHindiLetter2)
                Spacer(modifier = Modifier.height(20.dp))
                BtnClr(text = randomHindiLetter3)
                Spacer(modifier = Modifier.height(20.dp))
                AnsButton(animationState =animationState.value,
                    onToggleAnimationState =
                    {animationState.value = !animationState.value
                        visible = !visible
                    },"ठ", Color.Green)
                Spacer(modifier = Modifier.height(50.dp))
                Gifts(isGift = animationState.value, visible = visible,R.drawable.giftbox)
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ProgressBar(navController = navController,"fourth_screen",0.1f,1)
    }
}


