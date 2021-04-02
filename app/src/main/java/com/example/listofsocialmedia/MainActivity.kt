package com.example.listofsocialmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : SocialMediaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = ArrayList<SocialMedia>()
        data.add(SocialMedia(R.drawable.facebook, "Facebook", "Ini desc Facebook"))
        data.add(SocialMedia(R.drawable.instagram, "Instagram", "Ini desc Instagram"))
        data.add(SocialMedia(R.drawable.twitter, "Twitter", "Ini desc Twitter"))

        recyclerView = findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SocialMediaAdapter(data)
        recyclerView.adapter = adapter

        //bikin onclick di main
        SocialMediaAdapter(data).setOnItemClickCallback(object : SocialMediaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SocialMedia) {
                showSelectedItem(data)
            }
        })
    }

    private fun showSelectedItem(socialMedia: SocialMedia) {
        Toast.makeText(this, "Kamu memilih " + socialMedia.title, Toast.LENGTH_SHORT).show()
    }
    //bikin onclick di main

}