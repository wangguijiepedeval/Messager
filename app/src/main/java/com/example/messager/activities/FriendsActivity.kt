package com.example.messager.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.example.messager.R
import com.example.messager.fragments.FriendListFragment
import com.example.messager.fragments.MyFriendsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FriendsActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var loadingAnimationView: LottieAnimationView

    // 设置布局文件为 activity_friends.xml
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
        // 初始化 ViewPager2、TabLayout 和 LottieAnimationView 的实例
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)
        loadingAnimationView = findViewById(R.id.loading_animation_view)

        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "好友列表"
                1 -> tab.text = "我的好友"
            }
        }.attach()
        // 设置 ViewPager2 的缓存页面数量为 1
        viewPager.offscreenPageLimit = 1
        // 选项卡选择监听器 —— 后期优化扩展的时候可以使用
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 选中某个选项卡时进行操作
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 当一个选项卡未被选中时执行某些操作
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 可以设置重选操作
            }
        })
        // 调用 simulateLoading() 方法模拟加载过程
        simulateLoading()
    }

    private fun simulateLoading() {
        // 延迟5秒
        loadingAnimationView.postDelayed({
            loadingAnimationView.visibility = View.GONE
            viewPager.currentItem = 0 // Show "好友列表" fragment
        }, 5000)
    }

    private inner class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2 // 范围Fragment数量
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> FriendListFragment() //创建返回 "好友列表" fragment
                1 -> MyFriendsFragment() // 创建返回 "我的好友" fragment
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }
}
