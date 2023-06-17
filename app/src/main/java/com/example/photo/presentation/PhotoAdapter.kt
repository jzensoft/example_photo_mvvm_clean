package com.example.photo.presentation

import android.annotation.SuppressLint
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photo.R
import com.example.photo.data.model.photo.Photo
import com.example.photo.databinding.ViewPhotoBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.Holder>() {
    private val mData = mutableListOf<Photo>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Photo>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DataBindingUtil.inflate<ViewPhotoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.view_photo,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mData[position])
    }

    inner class Holder(itemView: ViewPhotoBinding) : RecyclerView.ViewHolder(itemView.root) {
        var view: ViewPhotoBinding

        init {
            view = itemView
        }

        fun bind(data: Photo) {
            view.tvTitle.text = data.title
            Glide.with(view.photo.context)
                .load(data.url)
                .into(view.photo)
        }
    }
}