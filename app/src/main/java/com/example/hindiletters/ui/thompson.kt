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

//for list
fun generateRandomHindiLettersList(count: Int):String  {
    val hindiLetters = "अआइईउऊएकखगघचजटठडतदधनपबमयरलवशसह"
    return (0 until count).map { generateRandomInt(0, hindiLetters.length - 1) }.map { hindiLetters[it] }.toString()
}



fun generateRandomHindiLetterStrings(count: Int): List<String> {
    val hindiLetters = "अआइईउऊऋऌऍऎएऐऑऒओऔकखगघङचछजझञटठडढणतथदधनपफबभमयरऱलळऴवशषसह"
    return (0 until count).map { generateRandomInt(0, hindiLetters.length - 1) }
        .map { hindiLetters[it].toString() }
}




// for level 2
fun generateRandomHindiLetter2(): String {
    val hindiLetters = "ऋऌऍऎऐऑऒओऔङछझञढणथफभऱळऴष"
    val index = generateRandomInt(0, hindiLetters.length - 1)
    return hindiLetters[index].toString()
}


fun main(){

    print(generateRandomHindiLetter())
    val count = 4
    val randomHindiLetters = generateRandomHindiLetterStrings(count)
    print(randomHindiLetters)
}
//    val hindiLetters = "अआइईउऊएकखगघचजटठडतदधनपबमयरलवशसह"
