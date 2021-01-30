package com.maxxxwk.animationl19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maxxxwk.animationl19.databinding.UsersListItemBinding

class UsersListAdapter :
    ListAdapter<User, UsersListAdapter.UserViewHolder>(UserDiffItemCallback()) {
    class UserViewHolder(private val binding: UsersListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            Glide.with(binding.root.context)
                .load(user.iconURL)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivUserIcon)
            binding.tvUserName.text = user.name
            binding.root.setOnClickListener {
                UserActivity.start(binding.root.context, binding.ivUserIcon, binding.tvUserName, user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            UsersListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}