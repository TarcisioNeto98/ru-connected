package com.tarcisio.ruconnected;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tarcisio.ruconnected.Model.Cardapio;

public class AlterarCardapio extends AppCompatActivity {
    FloatingActionButton fab;
    ListView listView;
    EditText data, principal, vegano, salada, guardicao, acompanhamento, suco, sobremesa;
    RadioGroup rg;
    RadioButton almoco, jantar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_cardapio);
        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Alterar Cardápio");

        almoco = findViewById(R.id.rbAlmoco);
        jantar = findViewById(R.id.rbJantar);
        rg = findViewById(R.id.rgOpcao);
        data = findViewById(R.id.etData);
        principal = findViewById(R.id.etPrincipal);
        vegano = findViewById(R.id.etVegano);
        salada = findViewById(R.id.etSalada);
        guardicao = findViewById(R.id.etGuarnicao);
        acompanhamento = findViewById(R.id.etAcompanhamento);
        suco = findViewById(R.id.etSuco);
        sobremesa = findViewById(R.id.etSobremesa);
        String dados[];
        Intent d = getIntent();

        dados = d.getStringArrayExtra("dados");

        principal.setText(dados[2]);
        vegano.setText(dados[3]);
        salada.setText(dados[4]);
        guardicao.setText(dados[5]);
        acompanhamento.setText(dados[6]);
        suco.setText(dados[7]);
        sobremesa.setText(dados[8]);
        data.setText(dados[1]);

        FirebaseDatabase database//Crio um objeto que será meu banco de dados
                = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
        //do meu banco passando sua URL
        final DatabaseReference cardapios = database.getReference("cardapios");
        fab = findViewById(R.id.fabMore);

        fab.setOnClickListener(view -> {
            int tipo = 0;
            if(data.getText().toString().isEmpty() || principal.getText().toString().isEmpty() || vegano.getText().toString().isEmpty()
                    || salada.getText().toString().isEmpty() || guardicao.getText().toString().isEmpty() || acompanhamento.getText().toString().isEmpty()
                    || suco.getText().toString().isEmpty() || sobremesa.getText().toString().isEmpty() || rg.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Campos vazios!", Toast.LENGTH_SHORT).show();
            }
            else{
                if(rg.getCheckedRadioButtonId() == R.id.rbAlmoco) tipo = 1;
                else tipo = 0;

                Cardapio c = new Cardapio(data.getText().toString(), principal.getText().toString(),
                        vegano.getText().toString(), salada.getText().toString(), guardicao.getText().toString(),
                        acompanhamento.getText().toString(), suco.getText().toString(), sobremesa.getText().toString(), tipo);
                cardapios.child(dados[9]).setValue(c);
                Toast.makeText(getApplicationContext(), "Cardápio alterado!", Toast.LENGTH_SHORT).show();
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
