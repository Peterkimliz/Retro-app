package com.example.retroapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retroapp.R
import com.example.retroapp.network.Characters
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter( val listData:List<Characters> ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
      holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class MainViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(characters: Characters){
            val name=itemView.findViewById<TextView>(R.id.textData)
            val imageViewData=itemView.findViewById<CircleImageView>(R.id.imageData)
            name.text=characters.name
            Picasso.get().load(characters.image).into(imageViewData)
        }
    }

}