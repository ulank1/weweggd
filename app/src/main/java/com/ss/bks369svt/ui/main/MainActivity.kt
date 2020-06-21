package com.ss.bks369svt.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.ss.bks369svt.R
import com.ss.bks369svt.model.Data
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()
    private lateinit var adapter:MainRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Как избавиться от простатита?"
        setupRv()
        getData(getDefaultLang())
    }

    private fun getDefaultLang():String{
        return Locale.getDefault().toString().substring(0,2)
    }

    private fun getData(lang:String){
        Log.e("LANG",lang)
        val docRef=db.collection(lang).document("xaHGKTjjAo0nkWeuYZdJ").collection("data")
        docRef.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Log.e("FAIL", "Listen failed.", exception)
                return@addSnapshotListener
            }
            if (snapshot != null) {

                var datas:ArrayList<Data> = ArrayList()
                Log.e("DATAS",snapshot.toString())
                for (document in snapshot) {
                    val img: String = document.data["img"] as String
                    val title: String = document.data["title"] as String
                    val descr: String = document.data["descr"] as String
                    datas.add(Data(img,title,descr))
                }

                adapter.swapData(datas)

            }

        }

    }

    private fun setupRv(){
        var manager = GridLayoutManager(this,1)
        rv.layoutManager = manager
        rv.setHasFixedSize(false)
        adapter = MainRvAdapter(this)
        rv.adapter = adapter
    }

}
