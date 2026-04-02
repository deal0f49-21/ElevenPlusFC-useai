package com.londonjobs.elevenplusfc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.londonjobs.elevenplusfc.data.local.entity.FlashcardEntity
import com.londonjobs.elevenplusfc.data.repository.FlashcardRepository
import com.londonjobs.elevenplusfc.domain.usecase.UpdateFlashcardReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
    private val repo: FlashcardRepository,
    private val updateUseCase: UpdateFlashcardReviewUseCase
) : ViewModel() {

    val flashcards = repo.getFlashcards()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun rateCard(card: FlashcardEntity, rating: Int) {
        viewModelScope.launch {
            updateUseCase(card, rating)
        }
    }

    fun insertDummyCards() {
        viewModelScope.launch {
            val samples = listOf(
                FlashcardEntity(word = "Candid", definition = "Honest and sincere", exampleSentence = "She gave a candid interview."),
                FlashcardEntity(word = "Eloquent", definition = "Fluent or persuasive in speaking", exampleSentence = "An eloquent speech moved the crowd.")
            )
            samples.forEach { repo.insert(it) }
        }
    }
}
