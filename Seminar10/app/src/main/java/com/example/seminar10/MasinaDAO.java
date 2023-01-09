package com.example.seminar10;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface MasinaDAO {
    @Insert
    void insereazaMasina(Masina masina);

    @Query("SELECT * FROM Masini")
    List<Masina> selectMasini();

    @Query("SELECT * FROM MASINI WHERE nrLocuri=:nrLoc")
    Masina selecteazaMasina(int nrLoc);

    @Update
    void updateMasina(Masina masina);
    //cu acest update se face modificare pentru toata masina

    @Query("UPDATE Masini SET nrLocuri=:nrLoc WHERE model=:model")
    void updateMasina2(int nrLoc, String model);

}
