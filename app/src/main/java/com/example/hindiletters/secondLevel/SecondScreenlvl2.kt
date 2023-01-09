package com.example.hindiletters.secondLevel

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hindiletters.R
import com.example.hindiletters.ui.*

val randomHindiLetter1_lvl2= generateRandomHindiLetter2()
val randomHindiLetter2_lvl2= generateRandomHindiLetter2()
@Composable
fun SecondScreen2(navController: NavController) {
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
                BtnClr(text = randomHindiLetter1_lvl2)
                Spacer(modifier = Modifier.height(20.dp))
                AnsButton(animationState =animationState.value,
                    onToggleAnimationState =
                    {animationState.value = !animationState.value
                        visible = !visible
                    },"ऋ",Color.Green)
                Spacer(modifier = Modifier.height(20.dp))
               BtnClr(text = randomHindiLetter2_lvl2)
                Spacer(modifier = Modifier.height(50.dp))
                Gifts(isGift = animationState.value,visible, R.drawable.giftbox)
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ProgressBar(navController=navController,"compound_level_1",0.5f,2)
    }
}
