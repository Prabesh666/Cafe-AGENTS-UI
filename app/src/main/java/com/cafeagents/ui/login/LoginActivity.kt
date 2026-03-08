package com.cafeagents.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafeagents.databinding.ActivityLoginBinding
import com.cafeagents.ui.chat.ChatActivity
import com.cafeagents.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // For demo purposes, navigate to ChatActivity
            startActivity(Intent(this, ChatActivity::class.java))
            finish()
        }

        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
