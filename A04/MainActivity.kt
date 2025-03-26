package com.juanitodev.sqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var txtResults: TextView
    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var btnInsert: Button
    private lateinit var btnFetch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)

        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        btnInsert = findViewById(R.id.btnInsert)
        btnFetch = findViewById(R.id.btnFetch)
        txtResults = findViewById(R.id.txtResults)

        btnInsert.setOnClickListener {
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toIntOrNull() ?: 0

            if (name.isNotEmpty() && age > 0) {
                dbHelper.insertUser(name, age)
                edtName.text.clear()
                edtAge.text.clear()
            }
        }

        btnFetch.setOnClickListener {
            val users = dbHelper.getAllUsers()
            txtResults.text = users.joinToString("\n") { "ID: ${it.id}, Nombre: ${it.name}, Edad: ${it.age}" }
        }
    }
}
