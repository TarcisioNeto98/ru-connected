package com.tarcisio.ruconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView textoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /*textoUsuario = findViewById(R.id.tvUsuario);

        Intent i = getIntent();

        textoUsuario.setText("Bem vindo " + i.getExtras().getString("usuario"));*/



    }
}
