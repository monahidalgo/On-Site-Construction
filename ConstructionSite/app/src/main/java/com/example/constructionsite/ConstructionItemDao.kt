package com.example.constructionsite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConstructionItemDao {
    @Query("SELECT * FROM construction_items")
    fun getAllItems(): List<ConstructionItem>

    @Insert
    fun insertItem(item: ConstructionItem)

    @Update
    fun updateItem(item: ConstructionItem)

    @Delete
    fun deleteItem(item: ConstructionItem)
}