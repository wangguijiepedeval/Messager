package com.example.messager.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messager.R
import com.example.messager.adapters.MessageAdapter

class MessageActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        recyclerView = findViewById(R.id.messageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // 创建了消息列表
        val messages = listOf("Message 1", "Message 2", "Message 3", "Message 4", "Message 5")
        // 设置点击项的回调函数 openDetailActivity
        val adapter = MessageAdapter(messages) { position ->
            openDetailActivity(position)
        }
        recyclerView.adapter = adapter
    }
    // 启动新的Activity
    private fun openDetailActivity(position: Int) {
        val intent = Intent(this, MessageDetailActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}
