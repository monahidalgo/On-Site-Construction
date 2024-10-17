package com.example.constructionsite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.constructionsite.databinding.ItemConstructionItemBinding

class ConstructionAdapter : RecyclerView.Adapter<ConstructionAdapter.ConstructionItemViewHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstructionItemViewHolder {
        val binding = ItemConstructionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConstructionItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConstructionItemViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list: List<ConstructionItem>) {
        differ.submitList(list)
    }

    class ConstructionItemViewHolder(private val binding: ItemConstructionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ConstructionItem) {
            binding.constructionItem = item
            binding.itemName.text = item.name
            binding.itemQuantity.text = item.quantity.toString()
            // Load the image using Glide or another image loading library if necessary
            // binding.imageView.setImageResource(item.imageResourceId)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ConstructionItem>() {
        override fun areItemsTheSame(oldItem: ConstructionItem, newItem: ConstructionItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ConstructionItem, newItem: ConstructionItem): Boolean {
            return oldItem == newItem
        }
    }
}
