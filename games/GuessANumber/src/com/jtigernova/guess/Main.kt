package com.jtigernova.guess

import java.util.*

fun main() {
    var input: String
    val userInput = Scanner(System.`in`)
    val rand = Random()

    do {
        println("I guessed ${rand.nextInt(10)}")
        input = userInput.nextLine()

    } while (input != "-1")
}