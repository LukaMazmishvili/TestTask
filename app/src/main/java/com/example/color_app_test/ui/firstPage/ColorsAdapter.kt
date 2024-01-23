package com.example.color_app_test.ui.firstPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.color_app_test.data.remote.models.ColorModel
import com.example.color_app_test.databinding.ItemCardBinding

class ColorsAdapter : ListAdapter<ColorModel, ColorsAdapter.ViewHolder>(ColorsDiffUtil()) {

    var onItemClicked: ((ColorModel) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ColorModel) {
            with(binding) {
                tvTitle.text = item.title
                tvAuthor.text = item.userName
                root.setOnClickListener {
                    onItemClicked?.invoke(item)
                }

            }
        }
    }

    class ColorsDiffUtil() : DiffUtil.ItemCallback<ColorModel>() {
        override fun areItemsTheSame(oldItem: ColorModel, newItem: ColorModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ColorModel, newItem: ColorModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }
}