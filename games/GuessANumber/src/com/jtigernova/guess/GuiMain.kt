package com.jtigernova.guess

import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame

fun main(){
    with(JFrame()){
        title = "Bry"
        size = Dimension(500, 500)
        isAlwaysOnTop = true
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        add(JButton("Test"))
        setLocationRelativeTo(null)
        pack()
        isVisible = true
    }
}