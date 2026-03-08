package com.cafeagents.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafeagents.databinding.ActivityProfileBinding
import com.cafeagents.ui.login.LoginActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        binding.btnEditProfile.setOnClickListener {
            // Edit profile logic
        }
    }
}
