package com.tarcisio.ruconnected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Usuario;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    EditText nome, email, matricula, senha, senhaRepetida;
    RadioGroup grupo;
    String chave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.cadastro_activity);

       ActionBar actionbar;
       actionbar = getSupportActionBar();
       actionbar.setTitle("Cadastro");

       grupo = findViewById(R.id.rgCadastro);
       nome = findViewById(R.id.editTextCNome);
       email = findViewById(R.id.editTextCEmail);
       matricula = findViewById(R.id.editTextCMatricula);
       senha = findViewById(R.id.editTextCSenha);
       senhaRepetida = findViewById(R.id.editTextCRSenha);

       Button cadastrar = (Button) findViewById(R.id.buttonCadastrar), testar;

       cadastrar.setOnClickListener(this);
    }

    public void onClick (View view){
        FirebaseDatabase database//Crio um objeto que será meu banco de dados
                = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
        //do meu banco passando sua URL
        final DatabaseReference usuarios = database.getReference( "usuarios");//O método getReference me retorna uma tabela.

        if(nome.getText().toString().isEmpty() || email.getText().toString().isEmpty() || matricula.getText().toString().isEmpty()
        || senha.getText().toString().isEmpty() || grupo.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Digite os dados!", Toast.LENGTH_SHORT).show();
        }

        else{
            if(senha.getText().toString().equals(senhaRepetida.getText().toString())){

                int tipo;

                if(grupo.getCheckedRadioButtonId() == R.id.radioButtonAluno) tipo = 1;
                else tipo = 0;

                usuarios.push().setValue(new Usuario(Integer.parseInt(matricula.getText().toString()), nome.getText().toString(), senha.getText().toString()
                , email.getText().toString(), tipo));
                Intent i;
                if(tipo == 1) i = new Intent(getApplicationContext(), Principal.class);
                else i = new Intent(getApplicationContext(), FuncionarioActivity.class);

                usuarios.addListenerForSingleValueEvent( new ValueEventListener() {
                    @Override
                    public void onDataChange( @NonNull DataSnapshot dataSnapshot) {//dataSnapshot são todos os meus dados.
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();//Eu crio uma lista de DataSnapshot, através do método
                        //getChildren().
                        for(DataSnapshot data : children) {//Percorro essa lista
                            Usuario usuario = data.getValue(Usuario.class);
                            String password = senha.getText().toString(), l = email.getText().toString();
                            if(password.equals(usuario.getSenha()) && l.equals(usuario.getEmail())){
                                chave = data.getKey();
                                String []dados = new String[4];
                                dados[0] = nome.getText().toString();
                                dados[1] = matricula.getText().toString();
                                dados[2] = email.getText().toString();
                                dados[3] = chave;
                                i.setAction(Intent.ACTION_SEND);
                                i.putExtra("dados", dados);
                                startActivity(i);
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled( @NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "eai", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else Toast.makeText(getApplicationContext(), "Redigite a senha corretamente.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
