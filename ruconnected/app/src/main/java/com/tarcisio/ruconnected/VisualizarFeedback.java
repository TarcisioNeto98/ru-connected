package com.tarcisio.ruconnected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Comida;
import com.tarcisio.ruconnected.Model.FeedBack;

import java.util.ArrayList;
import java.util.List;

public class VisualizarFeedback extends AppCompatActivity {

    List <String>lista = new ArrayList<>();
    Button buscar;
    EditText campo;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_feedback);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Visualizar Feedback");

        buscar = findViewById(R.id.bBuscarFeedback);
        campo = findViewById(R.id.campoBusca);
        listView = findViewById(R.id.lvBusca);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!campo.getText().toString().isEmpty()){
                    FirebaseDatabase database//Crio um objeto que será meu banco de dados
                            = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
                    //do meu banco passando sua URL
                    final DatabaseReference feedbacks = database.getReference( "feedbacks");

                    feedbacks.addListenerForSingleValueEvent( new ValueEventListener() {
                        @Override
                        public void onDataChange( @NonNull DataSnapshot dataSnapshot) {//dataSnapshot são todos os meus dados.
                            Iterable<DataSnapshot> children = dataSnapshot.getChildren();//Eu crio uma lista de DataSnapshot, através do método
                            //getChildren().
                            for(DataSnapshot data : children) {//Percorro essa lista
                                FeedBack feedback = data.getValue(FeedBack.class);
                                if(feedback.getData().equals(campo.getText().toString())) lista.add(feedback.getDescricao());
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,
                                    android.R.id.text1, lista);
                            listView.setAdapter(arrayAdapter);
                        }
                        @Override
                        public void onCancelled( @NonNull DatabaseError databaseError) {
                            Toast.makeText(getApplicationContext(), "eai", Toast.LENGTH_SHORT).show();
                        }

                    });
                }
                else Toast.makeText(getApplicationContext(), "Campo vazio!", Toast.LENGTH_SHORT).show();
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
