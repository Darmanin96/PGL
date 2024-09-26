package com.example.act01_01

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.jar.Attributes.Name//


//Daniel Darmanin Casariego

class MainActivity : AppCompatActivity() {

    object datosUsuario{
        const val Name: String = "Daniel"
        const val Age: Int = 25
        const val Language: String = "Kotlin"
    }

   class Programador : ProgramadorInterface{


       private fun getNombre(): String {
           return datosUsuario.Name
       }

       private fun getAge(): Int{
           return datosUsuario.Age
       }

       private fun getLanguage(): String{
           return datosUsuario.Language
       }

       override fun getProgrammerData(): ProgrammerData {
           val usuario : ProgrammerData = ProgrammerData(getNombre(),getAge(),getLanguage())
           return usuario
       }

   }

    interface ProgramadorInterface{
            fun getProgrammerData(): ProgrammerData
    }


    data class ProgrammerData(
        val name: String,
        val age: Int,
        val language: String){
    }


}











