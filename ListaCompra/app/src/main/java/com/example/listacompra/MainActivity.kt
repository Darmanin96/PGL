package com.example.listacompra

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable

//Daniel Darmanin Casariego

class MainActivity : AppCompatActivity() {

    private lateinit var productos: EditText
    private lateinit var cantidad: EditText
    private lateinit var precio: EditText
    private lateinit var lista: ListView
    private lateinit var añadir: FloatingActionButton
    private val listaCompra = ArrayList<Producto>()
    private lateinit var adapter: ProductoAdapter
    private lateinit var totalProducto: TextView
    private lateinit var totalPrecio: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControles()
        setupAdapter()
        setupListeners()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initControles() {
        productos = findViewById(R.id.Productos)
        cantidad = findViewById(R.id.Cantidad)
        precio = findViewById(R.id.Precio)
        lista = findViewById(R.id.lista)
        añadir = findViewById(R.id.Añadir)
        totalProducto = findViewById(R.id.totalProdcutos)
        totalPrecio = findViewById(R.id.totalPrecio)
    }

    private fun setupAdapter() {
        adapter = ProductoAdapter(this, listaCompra)
        lista.adapter = adapter
    }

    private fun setupListeners() {
        añadir.setOnClickListener {
            val nombreProducto = productos.text.toString()
            val cantidadValue = cantidad.text.toString().toIntOrNull() ?: 1
            val precioValue = precio.text.toString().toDoubleOrNull() ?: 0.0

            if (nombreProducto.isNotEmpty()) {
                val productoNuevo = Producto(nombreProducto, cantidadValue, precioValue)
                listaCompra.add(productoNuevo)
                adapter.notifyDataSetChanged()
                clearFields()
            }
        }

        lista.setOnItemClickListener { _, _, position, _ ->
            val producto = listaCompra[position]
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Eliminar Producto")
            builder.setMessage("¿Estás seguro de que quieres eliminar '${producto.nombre}'?")


            builder.setPositiveButton("Sí") { _, _ ->
                listaCompra.removeAt(position)
                adapter.notifyDataSetChanged()
            }


            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            builder.create().show()
        }
    }

    private fun clearFields() {
        productos.text.clear()
        cantidad.text.clear()
        precio.text.clear()
    }

    data class Producto(
        val nombre: String, val cantidad: Int = 1, val precio: Double = 0.0
    ) : Serializable

    class ProductoAdapter(context: Context, private val productos: List<Producto>) :
        ArrayAdapter<Producto>(context, 0, productos) {
        @SuppressLint("SetTextI18n")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val itemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.producto, parent, false)
            val datos = getItem(position)
            val productoView1 = itemView.findViewById<TextView>(R.id.nombreProducto)
            val cantidadView2 = itemView.findViewById<TextView>(R.id.cantidadProducto)
            val precioView3 = itemView.findViewById<TextView>(R.id.precioProducto)
            productoView1.text = datos?.nombre
            cantidadView2.text = "Cantidad: ${datos?.cantidad}"
            precioView3.text = "Precio: €${datos?.precio}"
            return itemView
        }
    }
}
