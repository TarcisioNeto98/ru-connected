package com.tarcisio.ruconnected;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tarcisio.ruconnected.Model.Cardapio;

public class BuscarCardapio extends AppCompatActivity {

    Button acessarCardapio;
    RadioGroup radioGroup;
    RadioButton jantar, almoco;
    EditText datat;
    Cardapio cardapio = null;
    int i = 0;
    int tipo = 0;
    String []array = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cardapio);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Buscar Cardápio!");

        radioGroup = findViewById(R.id.radioGroup);
        datat = findViewById(R.id.etData);
        jantar = findViewById(R.id.rbJantar);
        almoco = findViewById(R.id.rbAlmoco);

        acessarCardapio = findViewById(R.id.bAcessarCardapio);
        acessarCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroup.getCheckedRadioButtonId() != -1 && !datat.getText().toString().isEmpty()){
                    if(radioGroup.getCheckedRadioButtonId() == R.id.rbAlmoco) tipo = 1;
                    else tipo = 0;

                    FirebaseDatabase database//Crio um objeto que será meu banco de dados
                            = FirebaseDatabase. getInstance("https://ruconnected-1b6d7.firebaseio.com/");//Com o método estatico getInstance pego uma instancia
                    //do meu banco passando sua URL
                    final DatabaseReference cardapios = database.getReference("cardapios");
                    cardapios.addListenerForSingleValueEvent( new ValueEventListener() {

                        @Override
                        public void onDataChange( @NonNull DataSnapshot dataSnapshot) {//dataSnapshot são todos os meus dados.
                            Iterable<DataSnapshot> children = dataSnapshot.getChildren();//Eu crio uma lista de DataSnapshot, através do método
                            //getChildren().

                            for(DataSnapshot data : children) {//Percorro essa lista
                                cardapio = data.getValue(Cardapio.class);
                                Toast.makeText(getApplicationContext(), datat.getText().toString(), Toast.LENGTH_SHORT).show();
                                if(datat.getText().toString().equals(cardapio.getData()) && tipo == cardapio.getTipo()){
                                    array[2] = cardapio.getPrato1();
                                    array[3] = cardapio.getPrato2();
                                    array[4] = cardapio.getPrato3();
                                    array[5] = cardapio.getPrato4();
                                    array[6] = cardapio.getPrato5();
                                    array[7] = cardapio.getPrato6();
                                    array[8] = cardapio.getPrato7();
                                    array[9] = data.getKey();
                                    i = 1;
                                }
                            }
                            if(i != 0){
                                array[0] = tipo+"";
                                array[1] = datat.getText().toString();
                                Intent intent = new Intent(getApplicationContext(), AlterarCardapio.class);
                                intent.setAction(Intent.ACTION_SEND);
                                intent.putExtra("dados", array);
                                startActivity(intent);
                            }
                            else Toast.makeText(getApplicationContext(), "Cardapio não encontrado!", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onCancelled( @NonNull DatabaseError databaseError) {
                            Toast.makeText(getApplicationContext(), "eai", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else Toast.makeText(getApplicationContext(), "Preencha os campos!", Toast.LENGTH_SHORT).show();
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
