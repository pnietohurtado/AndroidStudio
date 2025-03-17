package com.example.intent;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras(); //Conjunto de claves o valores que yo puedo obtener, Mediante
        //el nombre que le pusimos en "intent.putExtra("nombre","Miguel") ", donde 'nombre' es la clave para poder
        //acceder a ese valor de la variable.

        int n = extras.getInt("numero"); // De esta forma vamos a obtener el número mediante la clave que le pusimos
        String s = extras.getString("nombre");

        Toast.makeText(this, "Numero de la variable "+n+ " nombre "+s, Toast.LENGTH_SHORT).show();
    }
}