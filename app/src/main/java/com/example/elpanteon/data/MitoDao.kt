package com.example.elpanteon.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface MitoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(mito: Mito): Long

    @Query("SELECT * FROM mitos WHERE diosId = :diosId ORDER BY titulo ASC")
    suspend fun obtenerPorDios(diosId: Int): List<Mito>

    @Query("SELECT * FROM mitos WHERE titulo LIKE '%' || :texto || '%' ORDER BY titulo ASC")
    suspend fun buscarPorTitulo(texto: String): List<Mito>

    @Query("SELECT * FROM mitos ORDER BY titulo ASC")
    suspend fun obtenerTodos(): List<Mito>

    @Transaction
    @Query("SELECT * FROM mitos")
    suspend fun obtenerMitosConDios(): List<MitoConDios>

    @Delete
    suspend fun eliminar(mito: Mito)
}