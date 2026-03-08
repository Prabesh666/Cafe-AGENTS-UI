package com.cafeagents.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafeagents.R
import com.cafeagents.adapter.ChatAdapter
import com.cafeagents.data.model.Message
import com.cafeagents.databinding.ActivityChatBinding
import com.cafeagents.ui.history.ChatHistoryActivity
import com.cafeagents.ui.profile.ProfileActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var chatAdapter: ChatAdapter
    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()

        binding.sendButton.setOnClickListener {
            val text = binding.messageEditText.text.toString()
            if (text.isNotEmpty()) {
                sendMessage(text)
                binding.messageEditText.text.clear()
            }
        }

        // Add dummy initial message
        if (messages.isEmpty()) {
            addMessage(Message("1", "Hello! Welcome to Cafe AGENTS. How can I help you with your order today?", "bot", System.currentTimeMillis(), false))
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Cafe Bot"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_history -> {
                startActivity(Intent(this, ChatHistoryActivity::class.java))
                true
            }
            R.id.action_profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRecyclerView() {
        chatAdapter = ChatAdapter(messages)
        binding.chatRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = chatAdapter
        }
    }

    private fun sendMessage(text: String) {
        addMessage(Message(System.currentTimeMillis().toString(), text, "user", System.currentTimeMillis(), true))
        
        // Mock bot response
        binding.root.postDelayed({
            addMessage(Message(System.currentTimeMillis().toString(), "Got it! I'm looking into that for you.", "bot", System.currentTimeMillis(), false))
        }, 1000)
    }

    private fun addMessage(message: Message) {
        messages.add(message)
        chatAdapter.notifyItemInserted(messages.size - 1)
        binding.chatRecyclerView.scrollToPosition(messages.size - 1)
    }
}
