package com.example.recicler_view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// El siguiente paso es crear un Adapter para gestionar nuestro RecyclerView y
// un ViewHolder encargado de asignar los valores visuales
//
// - El adapter se encarga de funcionar que el Recycler View Funcione
// - El ViewHolder se encarga de gestionar la parte visual

class MainAdapter(private val mDataset: List<String>, var click: (String) -> Unit ) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    // Un ViewHolder va a recibir una vista
    // y va a implementar las funciones
    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {

        val name = v.findViewById<TextView>(R.id.name)

        fun pintarDatos(dato: String) {
            Log.i("MainAdapter", dato)
            name.text = dato

            name.setOnClickListener{
                click(dato)
            }
        }
    }

    // se encarga de pillar el item_block y decirle al MainViewHolder que ahí es donde tiene que trabajar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        // LayoutInflater => como un "fuelle" de las ruedas¿?
        // parent.context => coge el contexto de donde estás poniendo las cosas
        // .inflate() => va a insertar algo al Recycler View para que se repita, en este caso R.layout.item_block
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return MainViewHolder(layout)
    }

    // se enccarga de tratar los datos y decirle al MainViewHolder quñé datos son
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataset.get(position)
        holder.pintarDatos(data)
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}