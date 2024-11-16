package com.example.proyectoandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización del Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inicialización del DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        // Configuración del ActionBarDrawerToggle
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Manejo de clics en el menú de navegación
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_preferences -> {
                    showThemeSelectionDialog()
                }
                R.id.nav_about -> {
                    showAboutDialog()
                }
                R.id.nav_exit -> {
                    finish()
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun showThemeSelectionDialog() {
        val themes = arrayOf("Tema Claro", "Tema Oscuro", "Tema del Sistema")
        val checkedItem = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> 1
            AppCompatDelegate.MODE_NIGHT_NO -> 0
            else -> 2
        }

        AlertDialog.Builder(this)
            .setTitle("Selecciona el Tema")
            .setSingleChoiceItems(themes, checkedItem) { dialog, which ->
                when (which) {
                    0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
                Toast.makeText(this, "Tema cambiado", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showAboutDialog() {
        val aboutMessage = """
            Nombre de la App: Mi Aplicación
            Versión: 1.0
            Desarrolladores: Equipo de Desarrollo
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Acerca de")
            .setMessage(aboutMessage)
            .setPositiveButton("OK", null)
            .show()
    }
}
