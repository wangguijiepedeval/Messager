package com.example.messager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messager.R

class MessageAdapter(private val messages: List<String>, private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    // 创建每个项的视图
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }
    // 使用 onBindViewHolder 将数据绑定到视图上
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message, position)
    }

    override fun getItemCount(): Int {
        return messages.size
    }
    // 设置了项的点击事件，并将点击的位置传递给回调函数
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(position)
                }
            }
        }

        fun bind(message: String, position: Int) {
            messageTextView.text = message
        }
    }
}
