package com.bulich.misha.workwithroom.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bulich.misha.workwithroom.data.models.Categories

@Dao
interface CategoriesDao {
    @Insert
    suspend fun insertCategory(categories: Categories)

    @Update
    suspend fun updateCategory(categories: Categories)

    @Delete
    suspend fun deleteCategory(categories: Categories)

    @Query("DELETE FROM categories_data_table")
    suspend fun deleteAllCategories()

    @Query("SELECT * FROM categories_data_table")
    fun getAllCategories(): LiveData<List<Categories>>
}