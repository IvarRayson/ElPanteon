package com.example.elpanteon.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Dios::class, Mito::class, Favorito::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun diosDao(): DiosDao

    abstract fun mitoDao(): MitoDao

    abstract fun favoritoDao(): FavoritoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Migración de la versión 1 a la versión 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {

            override fun migrate(database: SupportSQLiteDatabase){
                database.execSQL(
                 """
                  CREATE TABLE IF NOT EXISTS favoritos (
                    tipo TEXT NOT NULL,
                    elementoId INTEGER NOT NULL,
                    PRIMARY KEY(tipo, elementoId)
                    )
                 """.trimIndent()
                )
            }
        }

        fun obtenerBaseDatos(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "glosario_database"
                ).addMigrations(MIGRATION_1_2) //añadir migraciones version 2
                    .build()
                    .also {
                    INSTANCE = it
                }
            }
        }
    }
}