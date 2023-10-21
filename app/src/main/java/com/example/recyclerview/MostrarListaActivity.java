package com.example.recyclerview;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclerview.databinding.ActivityMostrarListaBinding; // Importa el paquete generado por ViewBinding

import static com.example.recyclerview.Repository.TrabajadorRepository.lstTrabajador;

public class MostrarListaActivity extends AppCompatActivity {

    private ActivityMostrarListaBinding binding; // Declara una variable de binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMostrarListaBinding.inflate(getLayoutInflater()); // Infla el diseño utilizando ViewBinding
        setContentView(binding.getRoot()); // Establece la vista raíz del diseño

        binding.lsvTrabajadores.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstTrabajador));
    }
}
