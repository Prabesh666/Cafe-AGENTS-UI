package com.cafeagents.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafeagents.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            // Register logic
            finish()
        }

        binding.tvLogin.setOnClickListener {
            finish()
        }
    }
}
