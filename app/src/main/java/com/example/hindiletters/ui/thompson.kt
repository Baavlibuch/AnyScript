package com.example.hindiletters.ui


import java.lang.Character.toString
import java.util.Arrays.toString
import java.util.Random

fun generateRandomInt(min: Int, max: Int): Int {
    return Random().nextInt(max - min + 1) + min
}

//for level 1
fun generateRandomHindiLetter(): String {
    val hindiLetters = "अआइईउऊएकखगघचजटठडतदधनपबमयरलवशसह"
    val index = generateRandomInt(0, hindiLetters.length - 1)
    return hindiLetters[index].toString()
}



// for level 2
fun generateRandomHindiLetter2(): String {
    val hindiLetters = "ऋऌऍऎऐऑऒओऔङछझञढणथफभऱळऴष"
    val index = generateRandomInt(0, hindiLetters.length - 1)
    return hindiLetters[index].toString()
}


fun generateRandomHindiCompoundLetter(): String {
    val hindiLetters = "रैज़ूविचुयोतृगौ"
    val index = generateRandomInt(0, hindiLetters.length - 1)
    return hindiLetters[index].toString()
}

//for compound letters
fun generateRandomHindiCompoundLetters(count: Int): List<String> {
    val hindiCompoundLetters = listOf(
        "गौ", "ज़ू", "हॉ","पृि","चि","वी","चॉ","पॉ","मौ","लृ"
    )
    return (0 until count).map { generateRandomInt(0, hindiCompoundLetters.size - 1) }
        .map { hindiCompoundLetters[it] }
}


fun main(){

    val rndLetters= generateRandomHindiCompoundLetters(1)
    print(rndLetters)
}
//    val hindiLetters = "अआइईउऊएकखगघचजटठडतदधनपबमयरलवशसह"
