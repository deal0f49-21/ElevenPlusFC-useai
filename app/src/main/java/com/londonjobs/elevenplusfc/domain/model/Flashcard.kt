package com.londonjobs.elevenplusfc.domain.model

data class Flashcard(
    val id: Int,
    val word: String,
    val definition: String,
    val exampleSentence: String,
    val imageUrl: String?,
    val synonym: String?,
    val antonym: String?,
    val masteryLevel: Int,
    val lastReviewed: Long,
    val interval: Int,
    val easeFactor: Double
)
