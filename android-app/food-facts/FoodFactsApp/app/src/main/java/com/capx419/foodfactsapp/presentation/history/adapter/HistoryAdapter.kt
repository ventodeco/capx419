package com.capx419.foodfactsapp.presentation.history.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capx419.foodfactsapp.databinding.ItemMenuHistoryBinding
import com.capx419.foodfactsapp.utils.ext.setImageUrl

class HistoryAdapter(
    private val data: MutableList<String>,
    private val context: Context,
    val listener: HistoryCallback? = null
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    val image = "http://kbu-cdn.com/dk/wp-content/uploads/spaghetti-poll-pedas.jpg"

    fun setData(data: MutableList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ItemMenuHistoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: String) {
            with(binding) {
                tvItemHistory.text = data
                imgItemHistory.setImageUrl(context, image, binding.pbItemHistory)
                cvItemHistory.setOnClickListener {
                    listener?.onClick(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemMenuHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    interface HistoryCallback {

        fun onClick(data: String)
    }
}