package com.example.minterfaz;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnConsultar;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la UI
        listView = findViewById(R.id.listViewUsuarios);
        btnConsultar = findViewById(R.id.btnConsultar);
        dbHelper = new DatabaseHelper(this);

        // Evento al presionar el botón
        btnConsultar.setOnClickListener(v -> mostrarUsuarios());
    }

    private void mostrarUsuarios() {
        Cursor cursor = dbHelper.getUsuarios();
        ArrayList<String> listaUsuarios = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                listaUsuarios.add(cursor.getString(1)); // Índice 1 = columna "nombre"
            } while (cursor.moveToNext());
        }
        cursor.close();

        if (listaUsuarios.isEmpty()) {
            Toast.makeText(this, "No hay usuarios registrados.", Toast.LENGTH_SHORT).show();
        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaUsuarios);
            listView.setAdapter(adapter);
        }
    }
}
