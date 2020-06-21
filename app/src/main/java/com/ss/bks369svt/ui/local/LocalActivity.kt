package com.ss.bks369svt.ui.local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ss.bks369svt.R
import com.ss.bks369svt.model.Data
import com.ss.bks369svt.model.Idea
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class LocalActivity : AppCompatActivity() {

    private lateinit var adapter:LocalRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Как избавиться от простатита?"
        setupRv()
        getData()

    }

    private fun getData() {
        var fileName = getDefaultLang()+".json"

        val json_string = application.assets.open(fileName).bufferedReader().use{
            it.readText()
        }

        var idea:Idea = Gson().fromJson(json_string,Idea::class.java)

        adapter.swapData(idea.idea)
    }

    private fun getDefaultLang():String{
        return Locale.getDefault().toString().substring(0,2)
    }

    private fun setupRv(){
        var manager = GridLayoutManager(this,1)
        rv.layoutManager = manager
        rv.setHasFixedSize(false)
        adapter = LocalRvAdapter(this)
        rv.adapter = adapter
    }
}
