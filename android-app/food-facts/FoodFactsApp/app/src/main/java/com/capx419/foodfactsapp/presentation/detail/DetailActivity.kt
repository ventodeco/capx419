package com.capx419.foodfactsapp.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capx419.foodfactsapp.R
import com.capx419.foodfactsapp.databinding.ActivityDetailBinding
import com.capx419.foodfactsapp.presentation.detail.adapter.DetailAdapter
import com.capx419.foodfactsapp.utils.Const.EXTRA_STRING
import com.capx419.foodfactsapp.utils.emptyString
import com.capx419.foodfactsapp.utils.ext.setImageUrl
import com.capx419.foodfactsapp.utils.isFavorited
import kotlinx.android.synthetic.main.activity_detail.btnFavDetail

class DetailActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context, data: String) {
            context.startActivity(Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_STRING, data)
            })
        }
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private var isFavorite = true
    private var data = emptyString()

    private val detailAdapter: DetailAdapter by lazy {
        DetailAdapter(
            mutableListOf(),
            context = this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(detailBinding.root)

        data = intent.getStringExtra(EXTRA_STRING) ?: emptyString()

        setSupportActionBar(detailBinding.toolbarDetail.toolbar)
        supportActionBar?.title = resources.getString(R.string.title_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailBinding.btnFavDetail.setOnClickListener {
            isFavorite = if (isFavorite) {
                btnFavDetail.isFavorited(true)
                false
            } else {
                btnFavDetail.isFavorited(false)
                true
            }
            Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
        }

        detailBinding.tvNameDetail.text = data
        detailBinding.tvCaloryDetail.text = "Total Kalori: 300Kcal"
        detailBinding.imgDetail.setImageUrl(
            this,
            "http://kbu-cdn.com/dk/wp-content/uploads/spaghetti-poll-pedas.jpg",
            detailBinding.pbDetail
        )

        detailAdapter.setData(dataDummy(7))

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
        detailBinding.rvFoodMaterial.apply {
            adapter = detailAdapter
            layoutManager = LinearLayoutManager(context)
        }
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