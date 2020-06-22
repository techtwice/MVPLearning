package com.example.mvplearning.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplearning.R
import com.example.mvplearning.home.HomeActivity
import com.example.mvplearning.shared_preference.SharedPreferenceConfigLogin

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    var preferenceConfig: SharedPreferenceConfigLogin? = null
    var etUsername: EditText? = null
    var etPassword: EditText? = null
    var btSignin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        preferenceConfig = SharedPreferenceConfigLogin(applicationContext)
        etUsername = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etUserPassword)
        btSignin = findViewById(R.id.btSignin)

        if (preferenceConfig!!.readLoginStatus()) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }


    private fun loginUserCheck() {
        val userName = etUsername!!.text.toString()
        val userPassword = etPassword!!.text.toString()
        if (userName == resources.getString(R.string.user_name_st) && userPassword == resources.getString(
                R.string.user_password_st
            )
        ) {
            startActivity(Intent(this, HomeActivity::class.java))
            preferenceConfig?.writeLoginStatus(true)
            finish()
        } else {
            Toast.makeText(this, "Login Failed .. Try Again", Toast.LENGTH_SHORT).show()
            etUsername!!.setText("")
            etPassword!!.setText("")
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btSignin -> loginUserCheck()
        }
    }

}


