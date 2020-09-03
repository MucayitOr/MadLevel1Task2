package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var correctAnswers: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.btnConfirm.setOnClickListener { onConfirm() }
    }

    private fun checkAnswer() {
        val answer1 = binding.Answer1.text.toString()
        val answer2 = binding.Answer2.text.toString()
        val answer3 = binding.Answer3.text.toString()
        val answer4 = binding.Answer4.text.toString()

        if (answer1 == "T" || answer1 =="t"){
            correctAnswers += 0
        }else{
            correctAnswers -= 1
        }

        if (answer2 == "F" || answer2 == "f"){
            correctAnswers += 0
        }else{
            correctAnswers -= 1
        }

        if (answer3 == "F" || answer3 == "f"){
            correctAnswers += 0
        }else{
            correctAnswers -= 1
        }

        if (answer4 == "F" || answer4 == "f"){
            correctAnswers += 0
        }else{
            correctAnswers -= 1
        }
        onAnswerCorrect(correctAnswers)
    }

    private fun onAnswerCorrect(str: Int){
        val msg = getString(R.string.correct) + " $str"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun reset(){
        when(correctAnswers) {
            0 -> correctAnswers =+ 4
            1 -> correctAnswers =+ 3
            2 -> correctAnswers =+ 2
            3 -> correctAnswers =+ 1
            4 -> correctAnswers =+ 0
        }
    }

    private fun onConfirm(){
        checkAnswer()
        reset()
    }
}