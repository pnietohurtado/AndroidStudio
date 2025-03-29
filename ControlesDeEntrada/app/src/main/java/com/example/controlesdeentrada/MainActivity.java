package com.example.controlesdeentrada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    String tipo = "";

    public void tipoAccion(View view) {

        Button button = (Button) view;

        if(button.getId() == R.id.Boton){
            Toast.makeText(this,"Le has dado al boton", Toast.LENGTH_SHORT ).show();
        }

    }

    public void SegundoBoton(View view) {
        Button button = (Button) view;

        if(button.getId() == R.id.button2){
            Toast.makeText(this, "Le has dado al segundo boton, cabrón", Toast.LENGTH_SHORT).show();
        }
    }



    public void evento(View view) {

        CheckBox check = (CheckBox) view;
        boolean chequeado = check.isChecked();

        if(check.getId() == R.id.averia){
            tipo = "Se te ha jodido el coche completo";
            Toast.makeText(this, tipo, Toast.LENGTH_SHORT).show();
        }else if(check.getId() == R.id.cristal){
            tipo = "Se te ha rajado el cristal";
            Toast.makeText(this, tipo, Toast.LENGTH_SHORT).show();
        }

    }
}