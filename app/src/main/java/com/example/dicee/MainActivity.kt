package com.example.dicee

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dicee.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    companion object {
        private const val DICE_ONE_IMG = "DICE_ONE_IMG"
        private const val DICE_TWO_IMG = "DICE_TWO_IMG"
    }

    private val images = mutableListOf(
        R.drawable.dice_one, R.drawable.dice_two, R.drawable.dice_three,
        R.drawable.dice_four, R.drawable.dice_five, R.drawable.dice_six
    )

    private lateinit var binding: ActivityMainBinding
    private var diceOneNumber = 0
    private var diceTwoNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rollButton.setOnClickListener {
            diceOneNumber = Random.nextInt(0 until images.size)
            binding.diceOne.setImageResource(
                images[diceOneNumber]
            )

            diceTwoNumber = Random.nextInt(0 until images.size)
            binding.diceTwo.setImageResource(
                images[diceTwoNumber]
            )

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DICE_ONE_IMG, diceOneNumber)
        outState.putInt(DICE_TWO_IMG, diceTwoNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.run {
            diceOne.setImageResource(images[savedInstanceState.getInt(DICE_ONE_IMG)])
            diceTwo.setImageResource(images[savedInstanceState.getInt(DICE_TWO_IMG)])
        }

        Toast.makeText(this, "Last State is Restored", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!isFinishing) {
            Toast.makeText(this, "Destroyed due to orientation or by OS", Toast.LENGTH_SHORT).show()
            Log.i("onDestroy", "Destroyed due to orientation or by OS")
        } else {
            // On Android 12, if you go back to the launcher by back button, app is stopped.
            // On Android 11 or lower, app is destroyed
            Log.i("onDestroy", "Destroyed by finish")
            Toast.makeText(this, "Destroyed by finish", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStop() {
        super.onStop()
        // On Android 12, if you go back to the launcher by back button, app is stopped.
        // On Android 11 or lower, app is destroyed
        Toast.makeText(this, "App Stopped", Toast.LENGTH_SHORT).show()
        Log.i("onStop", "App Stopped")
    }
}