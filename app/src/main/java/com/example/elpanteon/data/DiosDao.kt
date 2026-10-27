package com.example.elpanteon.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DiosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(dios: Dios): Long

    @Query("SELECT * FROM dioses ORDER BY nombre ASC")
    suspend fun obtenerTodos(): List<Dios>

    @Query("SELECT * FROM dioses WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Dios?

    @Delete
    suspend fun eliminar(dios: Dios)
}