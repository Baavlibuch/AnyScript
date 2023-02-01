package com.baavlibuch.anyscript.ui

sealed class Screen(val route:String){
    object MainScreen: Screen("main_screen")
    object SecondScreen: Screen("second_screen")
    object ThirdScreen: Screen("third_screen")
    object FourthScreen: Screen("fourth_screen")
    object FifthScreen: Screen("fifth_screen")
    object Lvl2FirstScreen: Screen("lvl2_first_screen")
    object DataSqlite: Screen("data_screen")
    object DataSqlite2: Screen("data_screen2")
    object CompoundLvl1: Screen("compound_level_1")
    object CompoundLvl2: Screen("compound_level_2")
    object Canvas: Screen("canvas")

}
