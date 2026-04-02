package com.londonjobs.elevenplusfc.di

import android.content.Context
import androidx.room.Room
import com.londonjobs.elevenplusfc.data.local.dao.FlashcardDao
import com.londonjobs.elevenplusfc.data.local.db.ElevenPlusDatabase
import com.londonjobs.elevenplusfc.data.repository.FlashcardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(appContext: Context): ElevenPlusDatabase =
        Room.databaseBuilder(
            appContext,
            ElevenPlusDatabase::class.java,
            "elevenplus_db"
        ).build()

    @Provides
    fun provideFlashcardDao(db: ElevenPlusDatabase): FlashcardDao = db.flashcardDao()

    @Provides
    @Singleton
    fun provideFlashcardRepository(dao: FlashcardDao) = FlashcardRepository(dao)
}
