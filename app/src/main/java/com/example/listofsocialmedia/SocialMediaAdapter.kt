package com.example.listofsocialmedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class SocialMediaAdapter(val listData: ArrayList<SocialMedia>) :
    RecyclerView.Adapter<SocialMediaAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    //bikin setonclick itemview di mainActivity
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: SocialMedia)
    }

    //bikin setonclick itemview di mainActivity

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fotoProfil.setImageResource(listData[position].fotoProfil)
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
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Satu Item View dklik" + listData[position].subTitle, Toast.LENGTH_SHORT).show()
//        }

        //keseluruhan item diklik tapi di kelas MainActivity nya
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listData[holder.adapterPosition])
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