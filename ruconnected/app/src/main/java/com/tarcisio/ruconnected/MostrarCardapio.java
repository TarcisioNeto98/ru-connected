package com.tarcisio.ruconnected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Cardapio;

public class MostrarCardapio extends AppCompatActivity {

    ListView listaCardapio;
    Button darFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cardapio);

        listaCardapio = (ListView)findViewById(R.id.lvCardapio);

        darFeedback = findViewById(R.id.bCriarFeedback);

        String s[], s2[] = new String[7];

        Intent i = getIntent();

        s = i.getStringArrayExtra("dados");

        ActionBar actionbar;
        actionbar = getSupportActionBar();

        if(s[0].equals("0")) actionbar.setTitle("Jantar");
        else actionbar.setTitle("Almoço");

        FirebaseDatabase database//Crio um objeto que será meu banco de dados
                = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
        //do meu banco passando sua URL
        final DatabaseReference cardapios = database.getReference("cardapios");
        cardapios.addListenerForSingleValueEvent( new ValueEventListener() {

            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot) {//dataSnapshot são todos os meus dados.
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();//Eu crio uma lista de DataSnapshot, através do método
                //getChildren().
                Cardapio cardapio;
                for(DataSnapshot dados : children) {//Percorro essa lista
                    cardapio = dados.getValue(Cardapio.class);

                    if(s[1].equals(cardapio.getData()) && Integer.parseInt(s[0]) == cardapio.getTipo()){
                        s2[0] = "Principal: "+cardapio.getPrato1();
                        s2[1] ="Vegano: "+ cardapio.getPrato2();
                        s2[2] = "Salada: "+cardapio.getPrato3();
                        s2[3] = "Guarnição: "+cardapio.getPrato4();
                        s2[4] = "Acompanhamento: "+cardapio.getPrato5();
                        s2[5] = "Suco: "+cardapio.getPrato6();
                        s2[6] = "Sobremesa: "+cardapio.getPrato7();
                    }
                }
                ArrayAdapter array = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_dropdown_item_1line, android.R.id.text1, s2);

                listaCardapio.setAdapter(array);
            }
            @Override
            public void onCancelled( @NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "eai", Toast.LENGTH_SHORT).show();
            }
        });
        listaCardapio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListAdapter a = listaCardapio.getAdapter();

                String w = (String) a.getItem(i);

                Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
            }
        });

        darFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicioanarFeedBack.class);
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("data", s[1]);
                startActivity(intent);
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
