package com.example.zoo.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.AppCore.Model.Exhibit
import com.example.zoo.AppCore.Model.Plant
import com.example.zoo.R
import com.squareup.picasso.Picasso

class ExhibitAdapter (
    ): RecyclerView.Adapter<ExhibitAdapter.ExhibitViewHolder>(){

    val HEADER = 0
    val NORMAL = 1

    private lateinit var itemClickListener: onItemClickListener;
    private var dataset: List<Plant> = listOf<Plant>()
    private val headerView: View? = null

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setClickListener(listener:onItemClickListener) {
        itemClickListener = listener
    }

    fun setData(data:List<Plant>){
        this.dataset = data
    }

    class ExhibitViewHolder(private val view: View, listener: onItemClickListener): RecyclerView.ViewHolder(view) {
        var titleTextView = view.findViewById<TextView>(R.id.card_title);
        var contentTextView = view.findViewById<TextView>(R.id.card_content);
        var photoView = view.findViewById<ImageView>(R.id.card_img)

        init{
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitViewHolder {
        var adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragement_card, parent, false)
        return ExhibitViewHolder(adapterLayout, itemClickListener);
    }

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        if (getItemViewType(position) == HEADER){
            holder.photoView.visibility = View.GONE
            holder.contentTextView.visibility = View.GONE
            return
        }

        var item = dataset[position]
        holder.titleTextView.text = item.nameCh
        holder.contentTextView.text = item.alsoKnown

//        TODO change the loading img
        Picasso
            .get()
            .load("https://pgw.udn.com.tw/gw/photo.php?u=https://uc.udn.com.tw/photo/2021/12/06/realtime/14701830.png&x=0&y=0&sw=0&sh=0&exp=3600")
            .centerCrop()
            .fit()
            .into(holder.photoView)
    }

    override fun getItemCount():Int {
        if (headerView != null)
            return dataset.size +1
        return dataset.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return HEADER
        return NORMAL
    }
}