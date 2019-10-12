package com.tarcisio.ruconnected.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "comidas")
public class Comida {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String descricao;

    public Comida(String descricao){
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
