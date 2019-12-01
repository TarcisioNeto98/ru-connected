package com.tarcisio.ruconnected.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "comidas")
public class Comida {

    //@PrimaryKey(autoGenerate = true)
    //private int id;
    //@ColumnInfo
    private String nome;
    //@ColumnInfo
    //@ColumnInfo

    public Comida(String nome){
        this.nome = nome;
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
