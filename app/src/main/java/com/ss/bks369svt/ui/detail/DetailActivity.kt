package com.ss.bks369svt.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.ss.bks369svt.R
import com.ss.bks369svt.model.Data
import com.ss.bks369svt.utils.setRoundedImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Как избавиться от простатита?"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val data:Data = intent.getSerializableExtra("data") as Data

        setRoundedImage(image,data.img,this)
        title1.text = data.title
        desc.text = data.descr

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
