package com.cafeagents.ui.history

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafeagents.adapter.ChatHistory
import com.cafeagents.adapter.HistoryAdapter
import com.cafeagents.databinding.ActivityChatHistoryBinding
import com.cafeagents.ui.chat.ChatActivity

class ChatHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        val dummyHistory = listOf(
            ChatHistory("1", "Order Inquiry", "Is my coffee ready?", "10:30 AM"),
            ChatHistory("2", "Menu Question", "What's the special today?", "Yesterday"),
            ChatHistory("3", "Feedback", "Great service!", "Oct 25"),
            ChatHistory("4", "Table Booking", "I'd like to book a table.", "Oct 24")
        )

        historyAdapter = HistoryAdapter(dummyHistory) { history ->
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("CHAT_ID", history.id)
            startActivity(intent)
        }

        binding.historyRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ChatHistoryActivity)
            adapter = historyAdapter
        }
    }
}
