package com.example.optionsmenuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter = Adapter(this)
    private val models = mutableListOf<Persons>()
    var realSize: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewID.adapter = adapter
        recyclerViewID.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewID.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        setDataInfo(1)
    }

    private fun setDataInfo(clickedItemNumber: Int) {
        for (i in realSize until realSize + clickedItemNumber) {
            val model = Persons()
            model.number = i + 1
            model.name = "Person ${i + 1}"
            model.description = "description"
            models.add(model)
        }
        realSize += clickedItemNumber
        adapter.setData(models)
    }

    fun itemClickListener(clickedItemNumber: Int) {
        setDataInfo(clickedItemNumber)
    }

    fun menuClickListener(view: View, clickedItemNumber: Int, realPosition: Int) {
        val optionsMenu = PopupMenu(this, view)
        val inflater = optionsMenu.menuInflater
        inflater.inflate(R.menu.menu_items, optionsMenu.menu)
        optionsMenu.show()
        optionsMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menuAddID -> {
                    setDataInfo(1)
                    Toast.makeText(this, "Added 1 item", Toast.LENGTH_SHORT).show()
                }

                R.id.menuDeleteID -> {
                    Toast.makeText(this, "Deleted item $clickedItemNumber", Toast.LENGTH_SHORT).show()

                    adapter.removeItemFunc(realPosition)
                    adapter.notifyDataSetChanged()
                }
            }
            return@setOnMenuItemClickListener true
        }
    }


}