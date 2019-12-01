package com.tarcisio.ruconnected;

import androidx.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Comida;
import com.tarcisio.ruconnected.Cadastro;
import com.tarcisio.ruconnected.Model.Usuario;

public class MainActivity extends AppCompatActivity{

    Button botaoEntrar;
    FloatingActionButton botaoFlutuante;
    com.tarcisio.ruconnected.Menu menu = new com.tarcisio.ruconnected.Menu();
    EditText senha, login;
    TextView textoCadastro;

    /*UsuarioDAO usuarios;
    ComidaDAO comidas;
    FeedBackDAO feedbacks;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoCadastro = findViewById(R.id.tvCadastro);

        botaoEntrar = findViewById(R.id.buttonEntrar);
        FirebaseDatabase database//Crio um objeto que será meu banco de dados
                = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
                    //do meu banco passando sua URL
        final DatabaseReference usuarios = database.getReference( "usuarios");//O método getReference me retorna uma tabela.

        //usuarios.push().setValue(new Usuario(4315122, "Tarcisio Neto", "12345", "neto1232", "rua da"));

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                senha = (EditText) findViewById(R.id.etSenha);
                login = (EditText) findViewById(R.id.etLogin);

                usuarios.addListenerForSingleValueEvent( new ValueEventListener() {
                    @Override
                    public void onDataChange( @NonNull DataSnapshot dataSnapshot) {//dataSnapshot são todos os meus dados.
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();//Eu crio uma lista de DataSnapshot, através do método
                        //getChildren().
                        int i = 0;
                        for(DataSnapshot data : children) {//Percorro essa lista
                            String chave = data.getKey();
                            Usuario usuario = data.getValue(Usuario.class);
                            String password = senha.getText().toString(), l = login.getText().toString();
                            if(password.equals(usuario.getSenha()) && l.equals(usuario.getEmail())){

                                Intent intent = getIntent();

                                if(usuario.getTipo() == 1) intent.setClass(getApplicationContext(), Principal.class);

                                else intent.setClass(getApplicationContext(), FuncionarioActivity.class);

                                intent.setAction(Intent.ACTION_SEND);
                                intent.putExtra("usuario", usuario.getNome());
                                i++;
                                startActivity(intent);
                                break;
                            }
                        }
                        if(i == 0) Toast.makeText(getApplicationContext(), "Senha ou Login invalidos!", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancelled( @NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "eai", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        textoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Cadastro.class);
                intent2.setAction(Intent.ACTION_VIEW);
                startActivity(intent2);
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
            menu.setClasse(FuncionarioActivity.class);
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
