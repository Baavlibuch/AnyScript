package com.example.hindiletters


import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hindiletters.database.Dta

import com.example.hindiletters.ui.Gifts
import com.example.hindiletters.ui.Navigation
import com.example.hindiletters.ui.Screen
import com.example.hindiletters.ui.theme.HindiLettersTheme
import java.io.BufferedReader
import java.io.InputStreamReader

import java.util.*

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
                }
            }
        }
    }
}


