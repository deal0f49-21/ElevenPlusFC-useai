package com.londonjobs.elevenplusfc.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.londonjobs.elevenplusfc.data.local.dao.FlashcardDao
import com.londonjobs.elevenplusfc.data.local.entity.FlashcardEntity

@Database(
    entities = [FlashcardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ElevenPlusDatabase : RoomDatabase() {
    abstract fun flashcardDao(): FlashcardDao
}
