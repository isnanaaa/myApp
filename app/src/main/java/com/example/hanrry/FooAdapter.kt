package com.example.hanrry

import android.content.Context
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
        val (name, description, image, where, type, history) = listFood[position]
        val food = listFood[position]

        holder.bind(food)
        holder.image.setImageResource(image)
        holder.name.text = name
        holder.description.text = description
        holder.where.text = where
        holder.type.text = type
        holder.history.text = history
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listFood[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            onItemClickCallback.onItemClicked(listFood[holder.adapterPosition])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.item_name)
        val description: TextView = itemView.findViewById(R.id.item_description)
        val image: ImageView = itemView.findViewById(R.id.img_item)
        val where: TextView = itemView.findViewById(R.id.detail_where)
        val type: TextView = itemView.findViewById(R.id.detail_type)
        val history: TextView = itemView.findViewById(R.id.detail_history)
        fun bind(food: Foo) {
            name.text = food.name
            description.text = food.description
            image.setImageResource(food.photo)
            where.text = food.where
            type.text = food.type
            history.text = food.history
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