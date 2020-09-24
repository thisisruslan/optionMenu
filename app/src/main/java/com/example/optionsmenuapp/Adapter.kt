package com.example.optionsmenuapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val activity: MainActivity) : RecyclerView.Adapter<ListViewHolder>() {

    var models: MutableList<Persons> = mutableListOf()

    fun setData(persons: MutableList<Persons>) {
        models = persons
        notifyDataSetChanged()
    }

    fun removeItemFunc(position: Int) {
        models.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, models.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(models[position], activity, models[position].number, position)
    }

    override fun getItemCount(): Int {
        return models.size
    }


}

