package com.example.zoo_db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var aux: String = "Texto inicial"
        var i: Int = 1
        val queue = Volley.newRequestQueue(this)
        val url = "192.168.1.69/zoo/index.php"

        /*val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener{ response ->
            val JsonArray = JSONArray(response)
            val jsonObject = JsonArray[2]
            print(jsonObject)
            if(i==1){
                aux = jsonObject.toString()
                i++
            }
        }, Response.ErrorListener { error ->
            aux = "Eror en conexion a la BD"
        })
        queue.add(stringRequest)*/

        val lvLista: ListView = findViewById(R.id.mnLvLista)

        val aguila = Animal("Águila", "Hábitat: Sabanas, praderas, bosques de climas semiáridos, selvas, humedales y laderas rocosas" +
                "\nAlimentación: Hierba, Hojas y Arbustos." +
                "\nTiempo de vida: 40 años", R.drawable.aguila)
        /*val cebra = Animal("Cebra", "Hábitat: Sabanas, praderas, bosques de climas semiáridos, selvas, humedales y laderas rocosas" +
                "\nAlimentación: Hierba, Hojas y Arbustos." +
                "\nTiempo de vida: 30 años", R.drawable.cebra)*/
        val listaAnimales = listOf<Animal>(aguila)
        //listaAnimales.
        val adapter  = AnimalesAdapter(this, listaAnimales)

        lvLista.adapter = adapter

        lvLista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, AnimalActivity::class.java)
            intent.putExtra("animal", listaAnimales[position])
            startActivity(intent)
        }

        mnBtAgregar.setOnClickListener {
            val intent = Intent(this, AgregarAnimalActivity::class.java)
            startActivity(intent)
        }
        //*/

    }
}