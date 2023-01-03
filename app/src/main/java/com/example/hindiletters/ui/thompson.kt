package com.example.hindiletters.ui

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


fun main(){

    print(generateRandomHindiLetter())
}
