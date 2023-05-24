package com.academy.bangkit.mystoryapp.ui.story.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.academy.bangkit.mystoryapp.R
import com.academy.bangkit.mystoryapp.databinding.ActivityDetailStoryBinding
import com.bumptech.glide.Glide

class DetailStoryActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        setupData()
    }

    private fun setupData() {
        val photoUrl = intent.getStringExtra(PHOTO_URL_EXTRA)
        val name = intent.getStringExtra(NAME_EXTRA)
        val description = intent.getStringExtra(DESC_EXTRA)


        Glide.with(this)
            .load(photoUrl)
            .into(detailBinding.thumbnailIv)

        detailBinding.apply {
            nameTv.text = name
            descTv.text = description
        }
    }

    companion object {
        const val PHOTO_URL_EXTRA = "photo_extra"
        const val NAME_EXTRA = "name_extra"
        const val DESC_EXTRA = "desc_extra"
    }
}