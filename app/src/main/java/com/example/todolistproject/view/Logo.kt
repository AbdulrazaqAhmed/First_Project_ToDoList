package com.example.todolistproject.view

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.todolistproject.MainActivity
import com.example.todolistproject.R
//import com.example.todolistproject.view.databinding.ActivityLogoBinding

class Logo :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        val intent = Intent(this, MainActivity::class.java)
        object : CountDownTimer(2000,1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                startActivity(intent)
            }

        }.start()

    }
}