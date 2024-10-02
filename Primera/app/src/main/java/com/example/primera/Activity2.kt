package com.example.primera

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val mensaje = intent.getStringExtra("Mensaje")


        val texto = findViewById<TextView>(R.id.textView2)
        texto.text = "Hola, $mensaje"
    }
}
