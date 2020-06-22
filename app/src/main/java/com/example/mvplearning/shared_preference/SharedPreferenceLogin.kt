package com.example.mvplearning.shared_preference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.mvplearning.R
import com.example.mvplearning.login.SignInActivity

@Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
class SharedPreferenceLogin(private var context: Context) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(
        context.resources.getString(R.string.login_preference),
        Context.MODE_PRIVATE
    )

    fun writeLoginStatus(status: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(
            context.resources.getString(R.string.login_status_preference),
            status
        )
        editor.apply()
    }

    fun readLoginStatus(): Boolean {
        var status = false
        status = sharedPreferences.getBoolean(
            context.resources.getString(R.string.login_status_preference), false
        )
        return status
    }

    fun userLogout() {
        writeLoginStatus(false)
        context.startActivity(Intent(context, SignInActivity::class.java))
    }


}