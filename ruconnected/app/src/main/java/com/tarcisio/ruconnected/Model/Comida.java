package com.tarcisio.ruconnected.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "comidas")
public class Comida {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String nome;
    @ColumnInfo
    private String descricao;
    @ColumnInfo
    private String chave;

    public Comida(String descricao, String nome, String chave){
        this.descricao = descricao;
        this.nome = nome;
        this.chave = chave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
