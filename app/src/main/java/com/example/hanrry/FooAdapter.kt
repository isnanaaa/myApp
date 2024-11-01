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
    (private val listFood: ArrayList<Foo>)
//     private val onClick: (Foo) -> Unit)
    : RecyclerView.Adapter<FooAdapter.ViewHolder>(){

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
        val (name, description, image) = listFood[position]
        val food = listFood[position]

        holder.bind(food)
        holder.image.setImageResource(image)
        holder.name.text = name
        holder.description.text = description
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listFood[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFood[holder.adapterPosition])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.item_name)
        val description: TextView = itemView.findViewById(R.id.item_description)
        val image: ImageView = itemView.findViewById(R.id.img_item)
        fun bind(food: Foo) {
            name.text = food.name
            description.text = food.description
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

//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val img: ImageView = itemView.findViewById(R.id.img_item)
//        val tvName: TextView = itemView.findViewById(R.id.item_name)
//        val tvDescription: TextView = itemView.findViewById(R.id.item_description)
//    }
}