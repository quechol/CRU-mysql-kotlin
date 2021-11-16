package com.example.zoo_db

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class AnimalesAdapter(private val mContext: Context, private val listaAnimales: List<Animal>) : ArrayAdapter<Animal>(mContext, 0, listaAnimales){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_animal, parent, false)
        val animal = listaAnimales[position]

        val tvNombre: TextView = layout.findViewById(R.id.itTvNombre)
        val tvDescripcion: TextView = layout.findViewById(R.id.itTvDescripcion)
        val ivAnimal: ImageView = layout.findViewById(R.id.itIvAnimal)

        tvNombre.text = animal.nombre
        //tvDescripcion.text = animal.descripcion
        ivAnimal.setImageResource(animal.imagen)

        return layout
    }
}