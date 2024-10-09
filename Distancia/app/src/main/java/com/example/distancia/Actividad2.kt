package com.example.distancia

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Actividad2 : AppCompatActivity() {

    private lateinit var imprimir: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)
        initControler()
        Sumar()

    }

    private fun initControler(){
        imprimir = findViewById(R.id.resultado)
    }

    private fun Sumar(){
        val bundle = intent.extras
        val millas = bundle?.getDouble("Milla en metros") ?: 0.0
        val pies = bundle?.getDouble("Pies en metros") ?: 0.0
        val pulgadas = bundle?.getDouble("Pulgadas en metros") ?: 0.0

        val resultadoTotal = millas + pies + pulgadas
        imprimir.text = "$resultadoTotal metros"

    }
}