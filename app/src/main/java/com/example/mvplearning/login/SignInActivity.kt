package com.example.mvplearning.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplearning.R
import com.example.mvplearning.home.HomeActivity
import com.example.mvplearning.shared_preference.SharedPreferenceLogin
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    private var preferenceConfig: SharedPreferenceLogin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        preferenceConfig = SharedPreferenceLogin(this)
        btSignin.setOnClickListener(this)

        if (preferenceConfig!!.readLoginStatus()) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    private fun userLogin() {

        val userName = etUserName.text.toString()
        val userPassword = etUserPassword.text.toString()
        if (userName == resources.getString(R.string.user_name_st) && userPassword == resources.getString(
                R.string.user_password_st
            )
        ) {
            startActivity(Intent(this, HomeActivity::class.java))
            preferenceConfig!!.writeLoginStatus(true)
            finish()
        } else {
            Toast.makeText(this, "Login Failed .. Try Again", Toast.LENGTH_SHORT).show()
            etUserName.setText("")
            etUserPassword.setText("")
        }
    }

    override fun onClick(view: View?) {
        val btSelect = view as Button
        when (btSelect.id) {
            R.id.btSignin -> userLogin()
        }
    }

}


