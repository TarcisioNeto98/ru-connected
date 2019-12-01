package com.tarcisio.ruconnected.Model;

//@Entity(tableName = "usuarios")
public class Usuario {

    //@PrimaryKey(autoGenerate = true)
    //private int id;
    //@ColumnInfo
    private int matricula;
    //@ColumnInfo
    private String nome;
    //@ColumnInfo
    private String senha;
    //@ColumnInfo
    private String email;

    private int tipo;

    public Usuario(){//É nescessario um construtor vazio, caso contrario, dar FirebaseException.

    }

    public Usuario(int matricula, String nome, String senha, String email, int tipo){
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public int getMatricula() {
        return matricula;
    }

    public void setCpf(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
