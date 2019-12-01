package com.tarcisio.ruconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MostrarCardapio extends AppCompatActivity {

    ListView listaCardapio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cardapio);

        listaCardapio = (ListView)findViewById(R.id.lvCardapio);

        String s[];

        Resources resources;
        resources = getResources();
        s = resources.getStringArray(R.array.tipos);

        ArrayAdapter array = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_dropdown_item_1line, android.R.id.text1, s);

        listaCardapio.setAdapter(array);

        listaCardapio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListAdapter a = listaCardapio.getAdapter();

                String w = (String) a.getItem(i);

                Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
