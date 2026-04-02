package com.londonjobs.elevenplusfc.data.repository

import com.londonjobs.elevenplusfc.data.local.dao.FlashcardDao
import com.londonjobs.elevenplusfc.data.local.entity.FlashcardEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlashcardRepository @Inject constructor(
    private val dao: FlashcardDao
) {
    fun getFlashcards(): Flow<List<FlashcardEntity>> = dao.getAll()
    suspend fun insert(card: FlashcardEntity) = dao.insert(card)
    suspend fun update(card: FlashcardEntity) = dao.update(card)
    suspend fun delete(card: FlashcardEntity) = dao.delete(card)
}
