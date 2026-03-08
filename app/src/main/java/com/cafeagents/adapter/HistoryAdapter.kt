package com.cafeagents.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeagents.databinding.ItemHistoryBinding

data class ChatHistory(val id: String, val title: String, val lastMessage: String, val date: String)

class HistoryAdapter(private val historyList: List<ChatHistory>, private val onItemClick: (ChatHistory) -> Unit) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = historyList[position]
        holder.binding.historyTitle.text = history.title
        holder.binding.historyLastMessage.text = history.lastMessage
        holder.binding.historyDate.text = history.date
        holder.binding.root.setOnClickListener { onItemClick(history) }
    }

    override fun getItemCount(): Int = historyList.size

    class HistoryViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)
}
