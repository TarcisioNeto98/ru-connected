package com.tarcisio.ruconnected;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    TextView textoUsuario;
    Button cardapio, alterarDados, sair;
    String []dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Menu");

        alterarDados = findViewById(R.id.bAlterarDados);
        cardapio = findViewById(R.id.bCardapio);
        sair = findViewById(R.id.bSair);

        Intent intent = getIntent();
        dados = intent.getStringArrayExtra("dados");



        cardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CardapioActivity.class);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

        alterarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(), AlterarDados.class);
                i2.setAction(Intent.ACTION_SEND);
                i2.putExtra("dados", dados);
                startActivity(i2);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(), MainActivity.class);
                i3.setAction(Intent.ACTION_VIEW);
                i3.putExtra("dados", dados);
                startActivity(i3);
            }
        });

        /*textoUsuario = findViewById(R.id.tvUsuario);

        Intent i = getIntent();

        textoUsuario.setText("Bem vindo " + i.getExtras().getString("usuario"));*/



    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflador = new MenuInflater(getApplicationContext());
        inflador.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        Intent i = new Intent();

        if(id == R.id.itemVisualizarCardapio){
            i.setClass(getApplicationContext(), CardapioActivity.class);
            i.setAction(Intent.ACTION_VIEW);
            startActivity(i);
        }

        else{
            i.setClass(getApplicationContext(), MainActivity.class);
            i.setAction(Intent.ACTION_VIEW);
            startActivity(i);
        }

        return true;
    }

}
