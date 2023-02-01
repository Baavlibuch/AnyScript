package com.baavlibuch.anyscript


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier

import com.baavlibuch.anyscript.ui.Navigation
import com.baavlibuch.anyscript.ui.theme.HindiLettersTheme

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HindiLettersTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                   Navigation()
                    //Dta()
                    //CanvasDraw()
                }
            }
        }
    }
}


