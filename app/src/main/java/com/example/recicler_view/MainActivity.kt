package com.example.recicler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val names = listOf<String>("Juan", "Alberto", "Maria", "Andrei", "Kevin", "Mustapha", "Edgar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRecycler = findViewById<RecyclerView>(R.id.mainRecycler)

        val myAdapter = MainAdapter(names) { name ->
            Toast.makeText(this, "$name", Toast.LENGTH_SHORT).show()
        }

//        mainRecycler.layoutManager  = GridLayoutManager(this, 2)

        // Ver la lista en vertical
        mainRecycler.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Ver la lista en vertical
//        mainRecycler.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        mainRecycler.adapter = myAdapter
    }


}