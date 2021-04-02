package com.example.listofsocialmedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SocialMediaAdapter(val listData: ArrayList<SocialMedia>) :
    RecyclerView.Adapter<SocialMediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.itemView.context).load(listData[position].fotoProfil).into(holder.fotoProfil)
        holder.title.text = listData[position].title
        holder.subTitle.text = listData[position].subTitle

        //title yang diklik
        holder.title.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Title diklik " + listData[position].title,
                Toast.LENGTH_SHORT
            ).show()
        }

        //keseluruhan item diklik tapi di kelas socialMediaAdapter
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Satu Item View dklik" + listData[position].title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var fotoProfil = itemView.findViewById<ImageView>(R.id.fotoProfil)
        var title = itemView.findViewById<TextView>(R.id.title)
        var subTitle = itemView.findViewById<TextView>(R.id.subTitle)
    }
}