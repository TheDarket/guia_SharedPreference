package com.example.recyclerview;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclerview.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        configSharedPreference();
        binding.btnIniciarSesion.setOnClickListener(v -> {
            showLoading();
        });
    }
    private void showLoading(){
        AlertDialog.Builder builder = new
                AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false);
        View progressBar = getLayoutInflater().inflate(R.layout.progressbar,
                null);
        builder.setView(progressBar);
        final AlertDialog dialog = builder.create();
        dialog.show();
        new Handler().postDelayed(() -> {
            try {
                if (dialog.isShowing()) {
                    if(verificarCredenciales(binding.edtEmail.getText().toString(),binding.edtPassword.getText().toString())){
                        startActivity(new Intent(LoginActivity.this,
                                MainActivity.class));
                        dialog.dismiss();
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Credenciales no validas", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 3000);
    }
    private void configSharedPreference(){
        SharedPreferences sharedPreferences = getSharedPreferences("MISDATOS",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", "admin@admin.com");
        editor.putString("pass","Admin");
        editor.apply();
    }
    private boolean verificarCredenciales(String email, String pass){
        boolean esValido = false;
        SharedPreferences sharedPreferences = getSharedPreferences("MISDATOS",
                Context.MODE_PRIVATE);
        String _email = sharedPreferences.getString("email","default");
        String _pass = sharedPreferences.getString("pass", "default");
        if (email.equals(_email) && pass.equals(_pass)){
            esValido = true;
        }
        return esValido;
    }
}
