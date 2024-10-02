package com.example.primera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editar = findViewById<EditText>(R.id.editText)
        val mensaje = findViewById<Button>(R.id.button)

        mensaje.setOnClickListener {
            val decir = editar.text.toString()
            val intento = Intent(this, Activity2::class.java)


            val bundle = Bundle()
            bundle.putString("Mensaje", decir)

            intento.putExtras(bundle)
            startActivity(intento)
        }
    }
}