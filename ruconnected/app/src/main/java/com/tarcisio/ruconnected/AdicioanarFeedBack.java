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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Cardapio;
import com.tarcisio.ruconnected.Model.FeedBack;

public class AdicioanarFeedBack extends AppCompatActivity {

    Button adicionar;
    EditText descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicioanar_feed_back);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Adicionar Feedback!");

        adicionar = findViewById(R.id.bAddFeedback);
        descricao = findViewById(R.id.etFeedback);

        Intent i = getIntent();


        FirebaseDatabase database//Crio um objeto que será meu banco de dados
                = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
        //do meu banco passando sua URL
        final DatabaseReference feedbacks = database.getReference("feedbacks");

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!descricao.getText().toString().isEmpty()) {
                    feedbacks.push().setValue(new FeedBack(descricao.getText().toString(), i.getExtras().getString("data")));
                    Toast.makeText(getApplicationContext(),"Feed back adicionado", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Campo vazio!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater inflador = new MenuInflater(getApplicationContext());
        inflador.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        Intent i = new Intent();

        if(id == R.id.itemVisualizarCardapio){
            i.setClass(getApplicationContext(), CardapioActivity.class);
            i.setAction(Intent.ACTION_VIEW);
            startActivity(i);
        }

        else{
            i.setClass(getApplicationContext(), MainActivity.class);
            i.setAction(Intent.ACTION_VIEW);
            startActivity(i);
        }

        return true;
    }

}
