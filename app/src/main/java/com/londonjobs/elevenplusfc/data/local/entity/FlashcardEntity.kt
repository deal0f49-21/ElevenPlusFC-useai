package com.londonjobs.elevenplusfc.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flashcards")
data class FlashcardEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val word: String,
    val definition: String,
    val exampleSentence: String,
    val imageUrl: String? = null,
    val synonym: String? = null,
    val antonym: String? = null,
    val masteryLevel: Int = 0, // 0–5
    val lastReviewed: Long = 0L,
    val interval: Int = 1,
    val easeFactor: Double = 2.5
)
