package com.example.listofsocialmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var socialMediaAdapter: SocialMediaAdapter
    private var listData: ArrayList<SocialMedia> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        socialMediaAdapter = SocialMediaAdapter(listData)

        val reference = FirebaseDatabase.getInstance().reference.child("SocialMedia")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot: DataSnapshot in dataSnapshot.children) {
                    val value = snapshot.getValue(SocialMedia::class.java)
                    recyclerView.adapter = socialMediaAdapter
                    listData.add(value!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

}