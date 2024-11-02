package com.example.hanrry

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FooAdapter
    (private val listFood: ArrayList<Foo>) : RecyclerView.Adapter<FooAdapter.ViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listFood.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, desc, image) = listFood[position]
        val food = listFood[position]

        holder.bind(food)
        holder.image.setImageResource(image)
        holder.name.text = name
        holder.desc.text = desc
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listFood[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            onItemClickCallback.onItemClicked(listFood[holder.adapterPosition])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.item_name)
        val desc: TextView = itemView.findViewById(R.id.item_desc)
        val image: ImageView = itemView.findViewById(R.id.img_item)
        fun bind(food: Foo) {
            name.text = food.name
            desc.text = food.description
            image.setImageResource(food.photo)
            itemView.setOnClickListener {
                onClickListener(food)
            }
        }

        private fun onClickListener(food: Foo) {

        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Foo)
    }
}