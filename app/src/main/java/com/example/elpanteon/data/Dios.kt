package com.example.elpanteon.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dioses")
data class Dios(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val atributo: String,
    val reino: String,
    val nota: String? = null,
    val imagen: String? = null
)