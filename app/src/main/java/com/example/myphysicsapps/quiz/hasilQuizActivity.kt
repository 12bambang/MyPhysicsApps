package com.example.myphysicsapps.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myphysicsapps.MainActivity
import com.example.myphysicsapps.R
import com.example.myphysicsapps.databinding.ActivityHasilQuizBinding

class hasilQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHasilQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hasil_quiz)

        binding = ActivityHasilQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT",0)
        binding.labelItungQuiz.text = getString(R.string.result_score,score)

        binding.btnCobalagi.setOnClickListener{
            startActivity(Intent(this@hasilQuizActivity, QuizActivity::class.java))
        }
        binding.btnbackdashboard.setOnClickListener{
            startActivity(Intent(this@hasilQuizActivity,MainActivity::class.java))
        }
    }
}
