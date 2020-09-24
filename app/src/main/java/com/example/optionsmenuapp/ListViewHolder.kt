package com.example.optionsmenuapp

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun populateModel( person: Persons, activity: MainActivity, clickedItemNumber: Int, realPosition: Int) {
        itemView.tvPersonID.text = person.name
        itemView.tvDescriptionID.text = person.description

        itemView.setOnClickListener {
            activity.itemClickListener(clickedItemNumber)
            if (clickedItemNumber == 1) Toast.makeText(activity, "Added $clickedItemNumber item",Toast.LENGTH_SHORT).show()
            else Toast.makeText(activity, "Added $clickedItemNumber items", Toast.LENGTH_SHORT).show()
        }
        itemView.imgMenuID.setOnClickListener {
            activity.menuClickListener(itemView.imgMenuID, clickedItemNumber, realPosition)
        }
    }

}