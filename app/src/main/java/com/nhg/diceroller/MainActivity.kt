package com.nhg.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        /*
        in this line of code we tried to make this button interactive
         */
        rollButton.setOnClickListener { rollDice() }
        // this function called because is should show a image instead of blank page
        rollDice()
    }

    /*
    this function is the base and logic of our program that generate a random image based on Dice Roll
     */
    private fun rollDice() {
        val dice = Dice(6)
        val imageView: ImageView = findViewById(R.id.imageView)
        val diceRoll = dice.roll()
        val drawableValue = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageView.setImageResource(drawableValue)
        imageView.contentDescription = diceRoll.toString()

    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}