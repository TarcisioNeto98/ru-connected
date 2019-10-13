package com.tarcisio.ruconnected.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tarcisio.ruconnected.Model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuarios")
    List<Usuario> pegarTodos();

    @Query("SELECT * FROM usuarios WHERE usuarios.senha LIKE :senha AND usuarios.nome LIKE :nome")
    Usuario pegarUsuario(String nome, String senha);

    @Insert
    void inserirUsuario(Usuario usuario);

    @Update
    void atualizarUsuario(Usuario usuario);

    @Delete
    void deletarUsuario(Usuario usuario);

}
