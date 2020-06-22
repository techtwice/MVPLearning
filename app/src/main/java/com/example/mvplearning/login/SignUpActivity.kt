package com.example.mvplearning.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mvplearning.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btSignin.setOnClickListener(this)
        btSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val btSelect = view as Button
        when (btSelect.id) {
            R.id.btSignin -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
            R.id.btSignUp -> {
                Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show()
            }
        }
    }
}