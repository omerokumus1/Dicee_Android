package com.example.dicee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dicee.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollButton.setOnClickListener {
            val images = mutableListOf(
                R.drawable.dice_one, R.drawable.dice_two, R.drawable.dice_three,
                R.drawable.dice_four, R.drawable.dice_five, R.drawable.dice_six
            )
            binding.diceOne.setImageResource(
                images[Random.nextInt(0 until images.size)]
            )
            binding.diceTwo.setImageResource(
                images[Random.nextInt(0 until images.size)]
            )

        }
    }
}