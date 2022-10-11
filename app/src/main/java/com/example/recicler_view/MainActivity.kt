package com.example.recicler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val names = listOf<String>("Juan", "Alberto", "Maria", "Andrei", "Kevin", "Mustapha", "Edgar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRecycler = findViewById<RecyclerView>(R.id.mainRecycler)

        val myAdapter = MainAdapter(names)
        mainRecycler.layoutManager  = GridLayoutManager(this, 2)
        mainRecycler.adapter = myAdapter
    }


}