package com.example.mvplearning.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mvplearning.R
import com.example.mvplearning.login.SignInActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            startActivity(Intent(this, SignInActivity::class.java))

            finish()
        }, SPLASH_TIME_OUT)

    }
}