package com.tarcisio.ruconnected.Model;

import androidx.annotation.ColorRes;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String cpf;
    @ColumnInfo
    private String nome;
    @ColumnInfo
    private String chave;
    @ColumnInfo
    private String senha;
    @ColumnInfo
    private String login;
    @ColumnInfo
    private String endereco;
    @ColumnInfo
    private int data;//Chave estrangeira

    public Usuario(String cpf, String nome, String chave, String senha, String login, String endereco){
        this.cpf = cpf;
        this.nome = nome;
        this.chave = chave;
        this.senha = senha;
        this.endereco = endereco;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
