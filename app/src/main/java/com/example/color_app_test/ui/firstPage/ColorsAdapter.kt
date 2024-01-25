package com.example.color_app_test.ui.firstPage

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.color_app_test.data.remote.models.ColorModelDto
import com.example.color_app_test.databinding.ItemCardBinding
import com.example.color_app_test.domain.models.ColorModel
import com.example.color_app_test.utils.ItemDiffUtil

class ColorsAdapter : ListAdapter<ColorModel, ColorsAdapter.ViewHolder>(ItemDiffUtil<ColorModel>()) {

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

                Glide.with(root).asDrawable().load(item.imageUrl).into(object :
                    CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: com.bumptech.glide.request.transition.Transition<in Drawable>?
                    ) {
                        llContainer.background = resource
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}

                })
            }
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