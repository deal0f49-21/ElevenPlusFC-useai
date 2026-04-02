package com.londonjobs.elevenplusfc.domain.usecase

import com.londonjobs.elevenplusfc.data.local.entity.FlashcardEntity
import com.londonjobs.elevenplusfc.data.repository.FlashcardRepository
import com.londonjobs.elevenplusfc.util.SM2
import javax.inject.Inject

class UpdateFlashcardReviewUseCase @Inject constructor(
    private val repository: FlashcardRepository
) {
    suspend operator fun invoke(card: FlashcardEntity, rating: Int) {
        val result = SM2.review(card.interval, card.easeFactor, rating)
        val updated = card.copy(
            interval = result.newInterval,
            easeFactor = result.newEase,
            lastReviewed = result.nextDate,
            masteryLevel = when (rating) {
                in 0..2 -> maxOf(0, card.masteryLevel - 1)
                in 3..4 -> card.masteryLevel + 1
                else -> (card.masteryLevel + 2).coerceAtMost(5)
            }
        )
        repository.update(updated)
    }
}
