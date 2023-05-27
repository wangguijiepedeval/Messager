package com.example.messager.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.messager.R

class MessageDetailActivity : AppCompatActivity() {
    // 获取从 MessageActivity 传递过来的位置 position，并将其显示在 positionTextView 中。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_detail)

        val position = intent.getIntExtra("position", -1)

        val positionTextView: TextView = findViewById(R.id.positionTextView)
        positionTextView.text = "第 $position 个item"
    }
}
