package com.amarinag.marvelapi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amarinag.marvelapi.data.db.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class AMGMarvelApiDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}