package com.bulich.misha.workwithroom.domain.repository

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.models.Categories

interface CategoriesCall {

    fun loadCategories(): LiveData<List<Categories>>

    suspend fun insertCategory(categories: Categories)

    suspend fun updateCategory(categories: Categories)

    suspend fun deleteCategory(categories: Categories)

    suspend fun deleteAllCategories()
}