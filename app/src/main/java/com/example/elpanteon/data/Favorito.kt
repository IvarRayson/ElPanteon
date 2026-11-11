package com.example.elpanteon.data

import androidx.room.Entity

/** Un favorito identifica un dios o un mito. */
@Entity(
    tableName = "favoritos",
    primaryKeys = ["tipo", "elementoId"]
)

data class Favorito(
    val tipo: String,
    val elementoId: Int
) {
    companion object {
        const val TIPO_DIOS = "DIOS"
        const val TIPO_MITO = "MITO"
    }
}