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
import com.tarcisio.ruconnected.Banco_de_Dados.DatabaseClient;
import com.tarcisio.ruconnected.DAO.ComidaDAO;
import com.tarcisio.ruconnected.DAO.FeedBackDAO;
import com.tarcisio.ruconnected.DAO.UsuarioDAO;
import com.tarcisio.ruconnected.Model.Comida;
import com.tarcisio.ruconnected.Model.FeedBack;
import com.tarcisio.ruconnected.Model.Usuario;

public class MainActivity extends AppCompatActivity{

    Button botaoEntrar;
    FloatingActionButton botaoFlutuante;
    com.tarcisio.ruconnected.Menu menu = new com.tarcisio.ruconnected.Menu();

    UsuarioDAO usuarios;
    ComidaDAO comidas;
    FeedBackDAO feedbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios = DatabaseClient.pegarInstancia(getApplicationContext()).usuarioDAO();
        feedbacks = DatabaseClient.pegarInstancia(getApplicationContext()).feedBackDAO();
        comidas = DatabaseClient.pegarInstancia(getApplicationContext()).comidaDAO();

        botaoFlutuante = (FloatingActionButton) findViewById(R.id.fabEntrar);
        botaoEntrar = (Button) findViewById(R.id.buttonEntrar);

        Usuario usuario = new Usuario("075.099.323-51", "Tarcisio Neto", "chave", "neto1998", "TarcisioNeto98", "Rua da libertação-136");

        Comida comida = new Comida("Muito deleciosa", "Batata Frita", "SSSS");
        comidas.inserirComida(comida);

        comida = comidas.pegarComida(comida.getNome());

        usuarios.inserirUsuario(usuario);

        Usuario user = usuarios.pegarUsuario(usuario.getNome(), usuario.getSenha());

        FeedBack feedBack = new FeedBack("Muito ruim", "resdsa", comida.getId(), user.getId());

        feedbacks.inserirFeedback(feedBack);

        feedBack = feedbacks.pegarFeedback(feedBack.getDescricao());

        Toast.makeText(getApplicationContext(), user.getId() + " " + user.getChave() + " " + comida.getNome() +
                " Feedback: " + feedBack.getDescricao() + " " + feedBack.getIdComida() + feedBack.getIdUsuario(), Toast.LENGTH_SHORT).show();

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
