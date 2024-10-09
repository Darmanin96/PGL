package com.example.distancia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var millas: EditText
    private lateinit var pies: EditText
    private lateinit var pulgadas: EditText
    private lateinit var transformarDistancias: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControles()
        transformarDistancias()
    }

    private fun initControles() {
        millas = findViewById(R.id.Millas)
        pies = findViewById(R.id.Pies)
        pulgadas = findViewById(R.id.Pulgadas)
        transformarDistancias = findViewById(R.id.Transformar)
    }

    private fun transformarDistancias() {
        transformarDistancias.setOnClickListener {
            val millasEnMetros = (millas.text.toString().toDoubleOrNull() ?: 0.0) * 1609.344
            val piesEnMetros = (pies.text.toString().toDoubleOrNull() ?: 0.0) * 0.3048
            val pulgadasEnMetros = (pulgadas.text.toString().toDoubleOrNull() ?: 0.0) * 0.0254
            val intent = Intent(this, Actividad2::class.java)
            val bundle = Bundle().apply {
                putDouble("Milla en metros", millasEnMetros)
                putDouble("Pies en metros", piesEnMetros)
                putDouble("Pulgadas en metros", pulgadasEnMetros)
            }
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
