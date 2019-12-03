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
    private String descricao;
    //@ColumnInfo


    public Comida(){

    }

    public Comida(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //@ColumnInfo


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
