package com.example.messager.fragments

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.messager.R

class FriendListFragment : Fragment() {

    private lateinit var friendListLayout: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 将布局文件 fragment_friend_list.xml 填充为片段的视图
        return inflater.inflate(R.layout.fragment_friend_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 为片段执行设置
        friendListLayout = view.findViewById(R.id.friend_list_layout)
        friendListLayout.alpha = 0f
        // 模拟加载过程
        simulateLoading()
    }

    private fun simulateLoading() {
        // 使用 PropertyValuesHolder 对象设置透明度动画，从 0 到 1
        friendListLayout.postDelayed({
            val fadeInAnimation = ObjectAnimator.ofPropertyValuesHolder(
                friendListLayout,
                PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f)
            )
            fadeInAnimation.duration = 500
            fadeInAnimation.start()
        }, 5000)
    }
}



