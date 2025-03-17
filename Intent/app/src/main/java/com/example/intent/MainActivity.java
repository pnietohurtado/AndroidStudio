package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    public void iniciarActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("numero", 5);
        intent.putExtra("nombre","Miguel");

        startActivity(intent);
    }

    public void crearAlarma(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Despierta")
                .putExtra(AlarmClock.EXTRA_HOUR, 20)
                .putExtra(AlarmClock.EXTRA_MINUTES, 55);
        if(intent.resolveActivity(getPackageManager())!=null)
            /*En el caso de que exista una aplicación en el móvila para poder ejecutar el "intent"
            * va a ejecutar la acción que le estamos especificando, si no existe, no va a hacer nada*/
        {
            startActivity(intent);
        }else{
            Log.i("Error", "No hay reloj!");
        }

    }

    public void marcarTelefono(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:112"));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.i("Error", "No hay telefono!");
        }

    }
}