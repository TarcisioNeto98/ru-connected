package com.tarcisio.ruconnected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Cardapio;
import com.tarcisio.ruconnected.Model.Comida;
import com.tarcisio.ruconnected.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdicionarCardapio extends AppCompatActivity {

    RecyclerView recyclerView;
    private LineAdapter mAdapter;
    FloatingActionButton fab;
    ListView listView;
    EditText data, principal, vegano, salada, guardicao, acompanhamento, suco, sobremesa;
    RadioGroup rg;
    RadioButton almoco, jantar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cardapio);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Adicionar Cardápio");

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
                cardapios.push().setValue(c);
                Toast.makeText(getApplicationContext(), "Cardápio adicionado!", Toast.LENGTH_SHORT).show();
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
