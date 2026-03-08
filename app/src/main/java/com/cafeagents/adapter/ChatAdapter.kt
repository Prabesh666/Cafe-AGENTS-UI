package com.cafeagents.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeagents.data.model.Message
import com.cafeagents.databinding.ItemChatBotBinding
import com.cafeagents.databinding.ItemChatUserBinding

class ChatAdapter(private val messages: List<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_USER = 1
        private const val VIEW_TYPE_BOT = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isFromUser) VIEW_TYPE_USER else VIEW_TYPE_BOT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_USER) {
            val binding = ItemChatUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            UserViewHolder(binding)
        } else {
            val binding = ItemChatBotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BotViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        if (holder is UserViewHolder) {
            holder.binding.userMessageText.text = message.text
        } else if (holder is BotViewHolder) {
            holder.binding.botMessageText.text = message.text
        }
    }

    override fun getItemCount(): Int = messages.size

    class UserViewHolder(val binding: ItemChatUserBinding) : RecyclerView.ViewHolder(binding.root)
    class BotViewHolder(val binding: ItemChatBotBinding) : RecyclerView.ViewHolder(binding.root)
}
