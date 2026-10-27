package com.example.elpanteon.data

import androidx.room.Embedded
import androidx.room.Relation

data class MitoConDios(
    @Embedded
    val mito: Mito,

    @Relation(
        parentColumn = "diosId",
        entityColumn = "id"
    )
    val dios: Dios
)