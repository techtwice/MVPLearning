package com.example.mvplearning.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplearning.R
import com.example.mvplearning.shared_preference.SharedPreferenceLogin

@Suppress("UNREACHABLE_CODE")
class HomeActivity : AppCompatActivity() {

    private var preferenceConfig: SharedPreferenceLogin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        preferenceConfig = SharedPreferenceLogin(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.menuActionLogout) {
            preferenceConfig!!.userLogout()
            true
        } else {
            Toast.makeText(this, "Menu Item Clicked", Toast.LENGTH_SHORT).show()
            true
        }
        return super.onOptionsItemSelected(item)
    }

}