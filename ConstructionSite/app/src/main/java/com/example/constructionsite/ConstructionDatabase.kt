package com.example.constructionsite

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ConstructionItem::class], version = 1)
abstract class ConstructionDatabase : RoomDatabase() {
    abstract fun constructionItemDao(): ConstructionItemDao

    companion object {
    }
}