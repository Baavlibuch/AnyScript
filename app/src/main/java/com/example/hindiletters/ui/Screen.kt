package com.example.hindiletters.ui

sealed class Screen(val route:String){
    object MainScreen: Screen("main_screen")
    object SecondScreen: Screen("second_screen")
    object ThirdScreen: Screen("third_screen")
    object FourthScreen: Screen("fourth_screen")
    object FifthScreen: Screen("fifth_screen")

}
