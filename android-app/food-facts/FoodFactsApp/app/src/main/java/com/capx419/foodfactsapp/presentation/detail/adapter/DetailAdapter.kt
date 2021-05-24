package com.capx419.foodfactsapp.presentation.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capx419.foodfactsapp.databinding.ItemMaterialFoodBinding
import com.capx419.foodfactsapp.utils.ext.setImageUrl

class DetailAdapter(
    private val data: MutableList<String>,
    private val context: Context
) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    val image = "http://kbu-cdn.com/dk/wp-content/uploads/spaghetti-poll-pedas.jpg"

    fun setData(data: MutableList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class DetailViewHolder(private val binding: ItemMaterialFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: String) {
            with(binding) {
                tvItemNameFoodMaterial.text = data
                tvItemCaloryFoodMaterial.text = "300Kcal"
                imgItemFoodMaterial.setImageUrl(context, image, binding.pbItemFoodMaterial)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(ItemMaterialFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}