package com.maxxxwk.animationl19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxxxwk.animationl19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvUsersList.layoutManager = LinearLayoutManager(this)
        binding.rvUsersList.adapter = UsersListAdapter().apply {
            submitList(loadData())
        }
    }

    private fun loadData() = listOf(
        User(
            0, "Alex Miller", "https://cdn3.iconfinder.com/data/icons/users/100/user_male_1-512.png"
        ),
        User(
            1, "Luka Melton", "https://banner2.cleanpng.com/20191112/kku/transparent-social-icon-male-user-icon-man-icon-5dcb2f0ede3143.1988722715735969429101.jpg"
        ),
        User(
            2, "Braxton Underwood", "https://cdn4.iconfinder.com/data/icons/avatars-32/90/24-512.png"
        ),
        User(
            3, "Jaron Hurst", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8Mp34I6Y_w9J9p3dxKpdlFW-Qp8nW6VD-Cw&usqp=CAU"
        ),
        User(
            4, "Sandra Kemp", "https://cdn1.iconfinder.com/data/icons/social-messaging-productivity-1-1/128/gender-female2-512.png"
        ),
        User(
            5, "Haylee Wilson", "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX28408818.jpg"
        ),
    )
}