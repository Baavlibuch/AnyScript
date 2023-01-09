package com.example.hindiletters.compoundLetters

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hindiletters.R
import com.example.hindiletters.ui.*


val randomCompoundLetter3= generateRandomHindiCompoundLetters(1)
val randomCompoundLetter4= generateRandomHindiCompoundLetters(1)
@Composable
fun CompoundLvl2(navController: NavController) {
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
                BtnClr(text = randomCompoundLetter4.toString().dropLast(1).drop(1))
                Spacer(modifier = Modifier.height(20.dp))
                BtnClr(text = randomCompoundLetter3.toString().dropLast(1).drop(1))
                Spacer(modifier = Modifier.height(20.dp))
                AnsButton(animationState =animationState.value,
                    onToggleAnimationState =
                    {animationState.value = !animationState.value
                        visible = !visible
                    },"गौ", Color.Green)
                Spacer(modifier = Modifier.height(50.dp))
                Gifts(isGift = animationState.value, visible = visible, R.drawable.giftbox)
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ProgressBar(navController = navController,"main_screen",0.7f,3)
    }
}


