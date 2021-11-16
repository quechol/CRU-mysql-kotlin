package com.example.zoo_db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class AnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        val animal = intent.getSerializableExtra("animal") as Animal
        val anTvNombre: TextView = findViewById(R.id.anTvNombre)
        val anTvDescripcion: TextView = findViewById(R.id.anTvDescripcion)
        val anIvAnimal: ImageView = findViewById(R.id.anIvAnimal)

        anTvNombre.text = animal.nombre
        anTvDescripcion.text = animal.descripcion
        anIvAnimal.setImageResource(animal.imagen)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.animal_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnEditar -> {
                /*val intent = Intent(this, AgregarAnimalActivity::class.java)
                intent.putExtra("animal", animal)
                startActivity(intent)*/
            }

            R.id.mnEliminar -> {
                /*animalLiveData.removeObservers(this)
                CoroutineScope(Dispatchers.IO).launch {
                    database.animales().delete(animal)
                    this@AnimalActivity.finish()
                }*/
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /*fun hola(view: View){

    }*/
}