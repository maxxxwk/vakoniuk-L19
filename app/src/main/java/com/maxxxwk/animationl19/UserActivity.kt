package com.maxxxwk.animationl19

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.toAndroidPair
import com.bumptech.glide.Glide
import com.maxxxwk.animationl19.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private val binding: ActivityUserBinding by lazy { ActivityUserBinding.inflate(layoutInflater) }

    companion object {
        private const val USER_NAME_KEY = "USER_NAME_KEY"
        private const val USER_ICON_URL_KEY = "USER_ICON_URL_KEY"

        fun start(context: Context, icon: ImageView, name: TextView, user: User) {
            val pairIcon = Pair<View, String>(
                icon,
                context.getString(R.string.user_icon_transition_name)
            ).toAndroidPair()
            val pairName = Pair<View, String>(
                name,
                context.getString(R.string.user_name_transition_name)
            ).toAndroidPair()
            Intent(context, UserActivity::class.java).apply {
                putExtra(USER_NAME_KEY, user.name)
                putExtra(USER_ICON_URL_KEY, user.iconURL)
                context.startActivity(
                    this,
                    ActivityOptions.makeSceneTransitionAnimation(
                        context as Activity,
                        pairIcon,
                        pairName
                    ).toBundle()
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val iconURL = intent.getStringExtra(USER_ICON_URL_KEY)
        val name = intent.getStringExtra(USER_NAME_KEY)
        Glide.with(this)
            .load(iconURL)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.ivUserIcon)
        binding.tvUserName.text = name
    }
}