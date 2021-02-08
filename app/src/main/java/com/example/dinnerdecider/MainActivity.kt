package com.example.dinnerdecider

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var choice: Int =0
   private var myStorechoice: Int =0
    lateinit var food: String
    lateinit var data: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        data = applicationContext.getSharedPreferences("choice", MODE_PRIVATE)

        binding.button.setOnClickListener {
            choice=Random.nextInt(0, 5)
            makeChoice()
            }

        }
    override fun onStart() {
        super.onStart()
        onRetrieve()

    }

    override fun onRestart() {
        super.onRestart()
        onSave()
    }

    override fun onStop() {
        super.onStop()
        onSave()

    }

    fun onSave(){
        var editor =data.edit()
        editor.putInt("food",choice)
        editor.commit()

    }

    fun onRetrieve(){
        myStorechoice = data.getInt("food",0)
        makeChoice()

        fun makeChoice(){
            when (myStorechoice) {
                0 -> {
                    food = "Chips"
                    binding.backgroud.setBackgroundResource(R.drawable.chips)

                }
                1 -> {
                    food = "Rice"
                    binding.backgroud.setBackgroundResource(R.drawable.rice)
                }
                2 -> {
                    food = "Ugali"
                    binding.backgroud.setBackgroundResource(R.drawable.ugali)
                }
                3 -> {
                    food = "Matoke"
                    binding.backgroud.setBackgroundResource(R.drawable.matoke)

                }
                4 -> {
                    food = "Chapati"
                    binding.backgroud.setBackgroundResource(R.drawable.chapati)

                }


                5 -> {
                    food = "Pilau"
                    binding.backgroud.setBackgroundResource(R.drawable.pilau)
                }
                else -> food = "We could not decide"

            }
            binding.textView.text = food

        }


    }

    private fun makeChoice() {
        when (myStorechoice) {
            0 -> {
                food = "Chips"
                binding.backgroud.setBackgroundResource(R.drawable.chips)

            }
            1 -> {
                food = "Rice"
                binding.backgroud.setBackgroundResource(R.drawable.rice)
            }
            2 -> {
                food = "Ugali"
                binding.backgroud.setBackgroundResource(R.drawable.ugali)
            }
            3 -> {
                food = "Matoke"
                binding.backgroud.setBackgroundResource(R.drawable.matoke)

            }
            4 -> {
                food = "Chapati"
                binding.backgroud.setBackgroundResource(R.drawable.chapati)

            }


            5 -> {
                food = "Pilau"
                binding.backgroud.setBackgroundResource(R.drawable.pilau)
            }
            else -> food = "We could not decide"

        }
        binding.textView.text = food

    }


}
