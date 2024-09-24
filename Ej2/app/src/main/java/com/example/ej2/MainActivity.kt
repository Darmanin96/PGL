package com.example.ej2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    object datosPropietarios {
        const val Name: String = "Juan"
    }

    object datosUsuario {
        const val Name: String = "Pepe"
        const val Age: Int = 25
        val Hobbies: List<String> = listOf("Surf", "Programación", "fútbol")
    }

    object etLog {
        const val TAG: String = "!:!:!:! TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val person: Persona = Persona(datosUsuario.Name, datosUsuario.Age, datosUsuario.Hobbies)
        botDeSeguridad(person)
    }

    private fun botDeSeguridad(person: Persona) {
        if (person.name == datosPropietarios.Name) {
            when {
                person.age < 18 -> {
                    Log.d(etLog.TAG, getString(R.string.mens_menor_edad))
                }
                person.age > 65 -> {
                    Log.d(etLog.TAG, getString(R.string.mens_mayor_edad))
                }
                else -> {
                    Log.d(etLog.TAG, getString(R.string.mens_final) + person.hobbies.joinToString(", "))
                }
            }
        } else {
            Log.d(etLog.TAG, getString(R.string.mens_error_acceso))
        }
    }

    data class Persona(
        val name: String,
        val age: Int,
        val hobbies: List<String>
    )
}
