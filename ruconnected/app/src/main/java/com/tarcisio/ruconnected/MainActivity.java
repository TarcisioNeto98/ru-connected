package com.tarcisio.ruconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{

    Button botaoEntrar;
    FloatingActionButton botaoFlutuante;
    com.tarcisio.ruconnected.Menu menu = new com.tarcisio.ruconnected.Menu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoFlutuante = (FloatingActionButton) findViewById(R.id.fabEntrar);
        botaoEntrar = (Button) findViewById(R.id.buttonEntrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText senha = (EditText) findViewById(R.id.etSenha);

                /*Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setClass(getApplicationContext(), Principal.class);
                //i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);*/

                Toast.makeText(getApplicationContext(), senha.getText()+"", Toast.LENGTH_SHORT).show();

            }
        });

        botaoFlutuante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SobreNos.class);
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
        menu.setContexto(getApplicationContext());//o contexto só pode ser resgatado dentro dos métodos que são implementados da AppCompatActivity
        Intent i;

        if(id == R.id.itemInicial){
            menu.setClasse(Principal.class);
            i = menu.criarIntent();
            startActivity(i);
            /*try {
                Intent i = menu.criarIntent();
                startActivity(i);
            }catch (NullPointerException e){
                e.printStackTrace();
            }*/
        }

        else{
            menu.setClasse(SobreNos.class);
            i = menu.criarIntent();
            startActivity(i);
        }

        return true;
    }
}
