package com.example.dinosaursapp.ui.screen.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dinosaursapp.R
import com.example.dinosaursapp.data.network.model.Air
import com.example.dinosaursapp.data.network.model.Aqua
import com.example.dinosaursapp.data.network.model.DinosaurType
import com.example.dinosaursapp.data.network.model.Land
import com.example.dinosaursapp.ui.base.AbsActivity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AbsActivity<DetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = intent.extras?.getParcelable(KEY) as DinosaurType?

        when (type) {
            is Land -> getLand(type)
            is Aqua -> getAqua(type)
            is Air -> getAir(type)
        }
    }

    private fun getLand(land: Land?) {
        tvTitle.text = land?.title.toString()
        tvDetail.text = land?.detail.toString()
        tvDescription1.text = land?.descriptionFirst.toString()
        tvDescription2.text = land?.descriptionSecond.toString()
        Glide.with(this).load(land?.imageMain).into(ivMainImage)
        tvStaticDetail.text = resources.getString(R.string.description_land)
    }

    private fun getAqua(aqua: Aqua) {
        tvTitle.text = aqua.title
        tvDetail.text = aqua.detail
        tvDescription1.text = aqua.descriptionFirst
        tvDescription2.text = aqua.descriptionSecond
        Glide.with(this).load(aqua.image).into(ivMainImage)
        tvStaticDetail.text = resources.getString(R.string.description_aqua)
    }

    private fun getAir(air: Air) {
        tvTitle.text = air.title
        tvDetail.text = air.detail
        tvDescription1.text = air.descriptionFirst
        tvDescription2.text = air.descriptionSecond
        Glide.with(this).load(air.image).into(ivMainImage)
        tvStaticDetail.text = resources.getString(R.string.description_air)
    }

    override fun provideLayoutId() = R.layout.activity_detail

    override fun provideViewModelClass() = DetailViewModel::class

    companion object {

        private const val KEY = "key"

        fun open(context: Context, list: DinosaurType): Intent =
            Intent(context, DetailActivity::class.java).apply {
                val extras = Bundle()
                extras.putParcelable(KEY, list)
                putExtras(extras)
            }
    }
}