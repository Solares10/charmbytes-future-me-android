package com.charmbytes.futureme.data.local

import androidx.room.Database
import android.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.charmbytes.futureme.data.local.model.Capsule

@Database (
    entities = [Letter::class], // in a table
    version = 1
    exportSchema = false
)

abstract class AppDatabase:RoomDatabase() {
    abstract fun capsuleDao(): CapsuleDao // link to DAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? null;

        fun getDatabase(context:Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "future_script_database"    // database file name
                );
                .fallbacktoDestructiveMigration() //resets databse if schema changes (remove in prod)
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
