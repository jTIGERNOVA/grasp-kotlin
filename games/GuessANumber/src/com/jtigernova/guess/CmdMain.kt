package com.jtigernova.guess

import java.util.*

fun main() {
    var input: String
    val userInput = Scanner(System.`in`)
    val rand = Random()

    do {
        val num = rand.nextInt(10) + 1

        println("I'm thinking of a number between 1 and 10. Guess it... Enter -1 to quit")

        input = userInput.nextLine()

        if (input == num.toString()) {
            println("You win!!!")
            break
        } else if (input == "-1") {
            println("See you next time. Bye...")
            break
        } else {
            println("I guessed $num. Sorry")
        }
    } while (true)
}