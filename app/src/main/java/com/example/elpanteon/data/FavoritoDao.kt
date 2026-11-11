package com.example.elpanteon.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(favorito: Favorito)

    @Query("DELETE FROM favoritos WHERE tipo = :tipo AND elementoId = :elementoId")
    suspend fun eliminar(tipo: String, elementoId: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM favoritos WHERE tipo = :tipo AND elementoId = :elementoId)")
    suspend fun esFavorito(tipo: String, elementoId: Int): Boolean

    @Query("SELECT * FROM favoritos ORDER BY tipo, elementoId")
    fun observarTodos(): Flow<List<Favorito>>

    @Query("SELECT * FROM favoritos WHERE tipo = :tipo ORDER BY elementoId")
    fun observarPorTipo(tipo: String): Flow<List<Favorito>>
    //Flow permite q se actualice automáticamente Biblioteca(cuando se añade o elimina favs) sin tener q recargar manualmente la pantalla.
}