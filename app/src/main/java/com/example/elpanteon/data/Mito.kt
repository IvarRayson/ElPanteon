package com.example.elpanteon.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "mitos",
    foreignKeys = [
        ForeignKey(
            entity = Dios::class,
            parentColumns = ["id"],
            childColumns = ["diosId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("diosId")]
)
data class Mito(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val diosId: Int,
    val titulo: String,
    val historia: String
)