package com.tarcisio.ruconnected;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class CardapioActivity extends AppCompatActivity {

    Button acessarCardapio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        acessarCardapio = findViewById(R.id.bAcessarCardapio);

        acessarCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MostrarCardapio.class);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

    }
}
