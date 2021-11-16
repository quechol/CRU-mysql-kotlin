package com.example.zoo_db

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.*
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_agregar_animal.*

import org.json.JSONException
import org.json.JSONObject

class AgregarAnimalActivity : AppCompatActivity() {
    //private final url : String = "127"
    var nombreVista:EditText?=null
    var descripcionVista:EditText?=null
    var imagenVista:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_animal)
        // idAnimal por si se envia algo extra
        var idAnimal: Int? = null
        //variables de campos de texto
        nombreVista=findViewById(R.id.agEtAnimal)
        descripcionVista=findViewById(R.id.agEtDescripcion)
        imagenVista=findViewById(R.id.agEtImagen)

        if(intent.hasExtra("animal")){
            print("Envio algo extra")
        }else{
            print("No se envio algo extra")
        }
        //boton
        BtnInsertar.setOnClickListener {
            //print("Se va a guardar algo")
            //clickBtnInsertar()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    fun clickBtnInsertar(view: View){
        val url = "http://192.168.1.130/zoo/insertar.php"
        val queue=Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(Request.Method.POST,url,
            Response.Listener<String> { response ->
                Toast.makeText(this, "Usuario insertado exitosamente",Toast.LENGTH_LONG).show()
            },Response.ErrorListener { error ->
                Toast.makeText(this, "Error $error",Toast.LENGTH_LONG).show()
            }){
            override fun getParams(): MutableMap<String, String> {
                val parametros = HashMap<String,String>()
                parametros.put("nombre",nombreVista?.text.toString())
                parametros.put("descripcion",descripcionVista?.text.toString())
                parametros.put("imagen",imagenVista?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }
}