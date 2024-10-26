package com.example.distancia

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//Daniel Darmnain Casariego


class Actividad2 : AppCompatActivity() {

    private lateinit var imprimir: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)
        initControler()
        sumar()
    }

    private fun initControler() {
        imprimir = findViewById(R.id.resultado)
    }

    @SuppressLint("DefaultLocale")
    private fun sumar() {
        val bundle = intent.extras
        val millas = bundle?.getDouble("Milla en metros") ?: 0.0
        val pies = bundle?.getDouble("Pies en metros") ?: 0.0
        val pulgadas = bundle?.getDouble("Pulgadas en metros") ?: 0.0
        val resultadoTotal = millas + pies + pulgadas
        imprimir.text = String.format("%.4f metros", resultadoTotal)
    }
}
