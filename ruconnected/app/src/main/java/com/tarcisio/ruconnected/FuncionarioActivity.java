package com.tarcisio.ruconnected;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FuncionarioActivity extends AppCompatActivity {

    Button adicionarPrato, cardapio, alterarDados, visualizarFeedback, buttonSair, alterarCardapio;
    String []dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Menu");

        Intent intent = getIntent();
        dados = intent.getStringArrayExtra("dados");

        alterarCardapio = findViewById(R.id.bAlterarPrato);

        buttonSair = findViewById(R.id.bSairFuncioanario);

        visualizarFeedback = findViewById(R.id.bVisualizarFeedback);

        adicionarPrato = findViewById(R.id.bAdicionarPrato);

        alterarDados = findViewById(R.id.bAlterarDados);

        adicionarPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ExcluirCardapio.class);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

        cardapio = findViewById(R.id.bCardapio);

        cardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AdicionarCardapio.class);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

        alterarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlterarDados.class);
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("dados", dados);
                startActivity(intent);
            }
        });

        visualizarFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), VisualizarFeedback.class);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair = new Intent(getApplicationContext(), MainActivity.class);
                sair.setAction(Intent.ACTION_VIEW);
                startActivity(sair);
            }
        });

        alterarCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BuscarCardapio.class);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflador = new MenuInflater(getApplicationContext());
        inflador.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        Intent i = new Intent();


        if(id == R.id.itemExcluirCardapio){
            i.setClass(getApplicationContext(), ExcluirCardapio.class);
            i.setAction(Intent.ACTION_VIEW);

        }

        else if(id == R.id.itemAddCardapio){
            i.setClass(getApplicationContext(), AdicionarCardapio.class);
            i.setAction(Intent.ACTION_VIEW);

        }

        else if(id == R.id.itemAlterarCardapio){
            i.setClass(getApplicationContext(), BuscarCardapio.class);
            i.setAction(Intent.ACTION_VIEW);

        }

        else if(id == R.id.VisualizarFeedback){
            i.setClass(getApplicationContext(), VisualizarFeedback.class);
            i.setAction(Intent.ACTION_VIEW);

        }

        else{
            i.setClass(getApplicationContext(), MainActivity.class);
            i.setAction(Intent.ACTION_VIEW);

        }

        startActivity(i);

        return true;
    }

}
