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
    private int pontuacao;
    //@ColumnInfo
    //private String chave;
    //@ColumnInfo(name = "id_comida")
    //private int idComida;
    //@ColumnInfo(name = "id_usuario")
    //private int idUsuario;

    public FeedBack(String descricao, int pontuacao){
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        //this.chave = chave;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
