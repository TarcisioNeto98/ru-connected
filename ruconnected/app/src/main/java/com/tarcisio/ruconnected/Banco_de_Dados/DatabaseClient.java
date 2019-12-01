/*package com.tarcisio.ruconnected.Banco_de_Dados;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static AppDatabase db;

    public static AppDatabase pegarInstancia(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "ruconnected").allowMainThreadQueries().build();
        }

        return db;
    }
}*/
