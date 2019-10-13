package com.tarcisio.ruconnected.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tarcisio.ruconnected.Model.FeedBack;

import java.util.List;

@Dao
public interface FeedBackDAO {

    @Query("SELECT * FROM feedbacks")
    List<FeedBack> pegarFeedbacks();

    @Query("SELECT * FROM feedbacks WHERE feedbacks.descricao LIKE :descricao")
    FeedBack pegarFeedback(String descricao);

    @Insert
    void inserirFeedback(FeedBack feedBack);

    @Update
    void atualizarFeedback(FeedBack feedBack);

    @Delete
    void deletarFeedback(FeedBack feedBack);

}
