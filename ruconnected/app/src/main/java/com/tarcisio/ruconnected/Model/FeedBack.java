package com.tarcisio.ruconnected.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/*@Entity(tableName = "feedbacks", foreignKeys =
        {@ForeignKey(entity = Comida.class, parentColumns = "id", childColumns = "id_comida", onDelete = 1, onUpdate = 1),
        @ForeignKey(entity = Usuario.class, parentColumns = "id", childColumns = "id_usuario", onDelete = 1, onUpdate = 1)})*///Adicionando duas chaves estrangeiras.
public class FeedBack {

    //@PrimaryKey(autoGenerate = true)
    //private int id;
    //@ColumnInfo
    private String descricao;
    private String data;
    //@ColumnInfo
    //private String chave;
    //@ColumnInfo(name = "id_comida")
    //private int idComida;
    //@ColumnInfo(name = "id_usuario")
    //private int idUsuario;

    public FeedBack(){

    }

    public FeedBack(String descricao, String data){
        this.descricao = descricao;
        this.data = data;
        //this.chave = chave;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
