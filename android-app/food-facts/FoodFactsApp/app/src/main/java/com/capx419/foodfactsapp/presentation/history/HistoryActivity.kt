package com.capx419.foodfactsapp.presentation.history

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capx419.foodfactsapp.R
import com.capx419.foodfactsapp.databinding.ActivityHistoryBinding
import com.capx419.foodfactsapp.presentation.detail.DetailActivity
import com.capx419.foodfactsapp.presentation.history.adapter.HistoryAdapter
import com.capx419.foodfactsapp.presentation.history.adapter.HistoryAdapter.HistoryCallback

class HistoryActivity : AppCompatActivity(), HistoryCallback {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, HistoryActivity::class.java))
        }
    }

    private lateinit var historyBinding: ActivityHistoryBinding

    private val historyAdapter: HistoryAdapter by lazy {
        HistoryAdapter(
            mutableListOf(),
            context = this,
            listener = this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        historyBinding = ActivityHistoryBinding.inflate(layoutInflater)

        setSupportActionBar(historyBinding.toolbarHistory.toolbar)
        supportActionBar?.title = resources.getString(R.string.title_history)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(historyBinding.root)

        historyAdapter.setData(dataDummy(6))

        initRecyclerView()
    }

    private fun dataDummy(amount: Int): MutableList<String> {
        val data = mutableListOf<String>()
        for (i in 0..amount) {
            data.add("Spageti")
        }
        return data
    }

    private fun initRecyclerView() {
        historyBinding.rvHistory.apply {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onClick(data: String) {
        DetailActivity.start(this, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}