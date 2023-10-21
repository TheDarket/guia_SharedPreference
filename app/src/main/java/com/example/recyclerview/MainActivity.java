package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclerview.databinding.ActivityMainBinding; // Importa la clase de ViewBinding
import com.example.recyclerview.Repository.TrabajadorRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TrabajadorRepository trabajadorRepository;
    private ActivityMainBinding binding; // Declara el objeto de ViewBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inicializa ViewBinding
        View view = binding.getRoot();
        setContentView(view);

        trabajadorRepository = new TrabajadorRepository();

        binding.btnAgregar.setOnClickListener(this); // Utiliza ViewBinding para acceder a los botones
        binding.btnMostrar.setOnClickListener(this);
        binding.btnAcercaDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.btnAgregar) { // Utiliza ViewBinding para comparar los botones
            Intent i1 = new Intent(this, SeleccionarTrabajadorActivity.class);
            startActivity(i1);
        } else if (v == binding.btnMostrar) {
            Intent i2 = new Intent(this, MostrarListaActivity.class);
            startActivity(i2);
        } else if (v == binding.btnAcercaDe) {
            Intent i3 = new Intent(this, DatosActivity.class);
            startActivity(i3);
        }
    }
}
