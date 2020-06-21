package com.ss.bks369svt.ui.main

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.ss.bks369svt.R
import com.ss.bks369svt.model.Data
import com.ss.bks369svt.ui.detail.DetailActivity
import com.ss.bks369svt.utils.setRoundedImage
import kotlinx.android.synthetic.main.item_main.view.*
import kotlin.collections.ArrayList


class MainRvAdapter(val context: Context) : RecyclerView.Adapter<MainRvAdapter.AdvertViewHolder>() {

    private var data: ArrayList<Data> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertViewHolder {
        return AdvertViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main, parent, false)
        )
    }


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: AdvertViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: ArrayList<Data>) {
        this.data =data
        notifyDataSetChanged()
    }

    inner class AdvertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Data) = with(itemView) {

            setRoundedImage(itemView.image,item.img,context)
            itemView.title1.text = item.title
            itemView.setOnClickListener {
                context.startActivity(Intent(context,DetailActivity::class.java).putExtra("data",item))
            }

        }
    }
}