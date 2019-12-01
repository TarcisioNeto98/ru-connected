/*package com.tarcisio.ruconnected.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tarcisio.ruconnected.Model.Comida;

import java.util.List;

@Dao
public interface ComidaDAO {

    @Query("SELECT * FROM comidas")
    List<Comida> pegarComidas();

    @Query("SELECT * FROM comidas WHERE comidas.nome LIKE :nome")
    Comida pegarComida(String nome);

    @Insert
    void inserirComida(Comida comida);

    @Update
    void atualizarComida(Comida comida);

    @Delete
    void deletarComida(Comida comida);

}
*/