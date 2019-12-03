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

public class AlterarDados extends AppCompatActivity implements View.OnClickListener{

    EditText nome, email, matricula, senha, senhaRepetida;
    RadioGroup grupo;
    String []dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Alterar Dados");

        Intent i = getIntent();

        dados = i.getStringArrayExtra("dados");

        grupo = findViewById(R.id.rgCadastro);
        nome = findViewById(R.id.editTextCNome);
        email = findViewById(R.id.editTextCEmail);
        matricula = findViewById(R.id.editTextCMatricula);
        senha = findViewById(R.id.editTextCSenha);
        senhaRepetida = findViewById(R.id.editTextCRSenha);

        nome.setText(dados[0]);
        matricula.setText(dados[1]);
        email.setText(dados[2]);

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
                Toast.makeText(getApplicationContext(), dados[3], Toast.LENGTH_SHORT).show();
                usuarios.child(dados[3]).setValue(new Usuario(Integer.parseInt(matricula.getText().toString()), nome.getText().toString(), senha.getText().toString()
                        , email.getText().toString(), tipo));
                Toast.makeText(getApplicationContext(), "Dados alterados!", Toast.LENGTH_SHORT).show();
                }
            else Toast.makeText(getApplicationContext(), "Redigite a senha corretamente.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
