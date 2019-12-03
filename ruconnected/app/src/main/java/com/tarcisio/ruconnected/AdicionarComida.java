package com.tarcisio.ruconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tarcisio.ruconnected.Model.Comida;

public class AdicionarComida extends AppCompatActivity {

    Button adicionarPrato;
    EditText nome, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_comida);

        adicionarPrato = findViewById(R.id.bAdicionarComida);
        nome = findViewById(R.id.etNomeComida);
        descricao = findViewById(R.id.etDescricao);

        FirebaseDatabase database//Crio um objeto que será meu banco de dados
                = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
        //do meu banco passando sua URL
        final DatabaseReference comidas = database.getReference( "comidas");//O método getReference me retorna uma tabela.


        adicionarPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nome.getText().toString().isEmpty() || descricao.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Campo vazio!", Toast.LENGTH_SHORT).show();
                else{
                    comidas.push().setValue(new Comida(nome.getText().toString(), descricao.getText().toString()));
                    Toast.makeText(getApplicationContext(), "Prato adicioando!", Toast.LENGTH_SHORT).show();
                    nome.setText("");
                    descricao.setText("");
                }
            }
        });

    }
}
