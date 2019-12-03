package com.tarcisio.ruconnected;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SobreNos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos);

        ActionBar actionbar;
        actionbar = getSupportActionBar();
        actionbar.setTitle("Sobre nós");

    }
}
