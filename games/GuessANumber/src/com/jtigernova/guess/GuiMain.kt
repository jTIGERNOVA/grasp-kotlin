package com.jtigernova.guess

import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JLabel

fun main() {
    GuiMain().doMain()
}

class GuiMain {

    fun doMain() {
        with(JFrame()) {
            title = "Guess A Number"
            minimumSize = Dimension(500, 500)
            isAlwaysOnTop = true
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE

            add(JLabel("Help"))
            setLocationRelativeTo(null)
            pack()
            isVisible = true
        }
    }
}