package com.example.act01_01

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {

    class Programado : ProgramadorInterface{

        private fun getName(): String{
            return "Daniel"
        }

        private fun getAge(): Int{
            return 25
        }

        private fun getLanguage(): String{
            return "Kotlin"
        }

        override fun getProgrammerData(): ProgrammerData {
            val name = getName()
            val age = getAge()
            val language = getLanguage()
            return ProgrammerData(name, age, language)
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











