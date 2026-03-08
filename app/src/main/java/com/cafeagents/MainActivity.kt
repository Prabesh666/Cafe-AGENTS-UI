package com.cafeagents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafeagents.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Splash screen redirection
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
