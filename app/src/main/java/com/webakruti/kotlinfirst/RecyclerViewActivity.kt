package com.webakruti.kotlinfirst

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.webakruti.kotlinfirst.adapter.RecyclerAdapter

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setAdapter(RecyclerAdapter(applicationContext, 15))

        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack) as ImageView
        imageViewBack.setOnClickListener {
            val intent1 = Intent(this@RecyclerViewActivity, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }


    }
}
