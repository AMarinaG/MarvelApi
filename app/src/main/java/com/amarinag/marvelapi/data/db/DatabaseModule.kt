package com.amarinag.marvelapi.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AMGMarvelApiDatabase =
        Room.databaseBuilder(
            context,
            AMGMarvelApiDatabase::class.java,
            "amg_marvelapi.db"
        ).build()

    @Singleton
    @Provides
    fun provideCharacterDao(database: AMGMarvelApiDatabase): CharacterDao = database.characterDao()
}