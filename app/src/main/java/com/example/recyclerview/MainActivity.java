package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.Repository.TrabajadorRepository;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TrabajadorRepository trabajadorRepository;
    private Button Agregar, Mostrar, Acerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trabajadorRepository = new TrabajadorRepository();

        Agregar = findViewById(R.id.btnAgregar);
        Agregar.setOnClickListener(this);
        Mostrar = findViewById(R.id.btnMostrar);
        Mostrar.setOnClickListener(this);
        Acerca = findViewById(R.id.btnAcercaDe);
        Acerca.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar) {
            Intent i1 = new Intent(this, SeleccionarTrabajadorActivity.class);
            startActivity(i1);
        } else if (v.getId() == R.id.btnMostrar) {
            Intent i2 = new Intent(this, MostrarListaActivity.class);
            startActivity(i2);
        } else if (v.getId() == R.id.btnAcercaDe) {
            Intent i3 = new Intent(this, DatosActivity.class);
            startActivity(i3);
        }
    }
}