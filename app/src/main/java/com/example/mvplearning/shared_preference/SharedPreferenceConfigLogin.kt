package com.example.mvplearning.shared_preference

import android.content.Context
import android.content.SharedPreferences
import com.example.mvplearning.R

class SharedPreferenceConfigLogin {

    private var sharedPreferences: SharedPreferences? = null
    private var context: Context? = null

    fun SharedPreferenceConfigLogin(context: Context) {
        this.context = context
        sharedPreferences = context.getSharedPreferences(
            context.resources.getString(R.string.login_preference),
            Context.MODE_PRIVATE
        )
    }

    fun writeLoginStatus(status: Boolean) {
        val editor = sharedPreferences!!.edit()
        editor.putBoolean(
            context!!.resources.getString(R.string.login_status_preference),
            status
        )
        editor.commit()
    }

    fun readLoginStatus(): Boolean {
        var status = false
        status = sharedPreferences!!.getBoolean(
            context!!.resources.getString(R.string.login_status_preference), false
        )
        return status
    }


}