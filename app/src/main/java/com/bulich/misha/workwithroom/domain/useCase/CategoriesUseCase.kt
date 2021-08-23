package com.bulich.misha.workwithroom.domain.useCase

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.models.Categories
import com.bulich.misha.workwithroom.domain.repository.CategoriesCall

class CategoriesUseCase(private val categoriesCall: CategoriesCall) {

     fun loadCategories(): LiveData<List<Categories>> {
        return categoriesCall.loadCategories()
    }

     suspend fun insertCategory(categories: Categories) {
        categoriesCall.insertCategory(categories)
    }

     suspend fun updateCategory(categories: Categories) {
        categoriesCall.updateCategory(categories)
    }

     suspend fun deleteCategory(categories: Categories) {
        categoriesCall.deleteCategory(categories)
    }

     suspend fun deleteAllCategories() {
        categoriesCall.deleteAllCategories()
    }
}