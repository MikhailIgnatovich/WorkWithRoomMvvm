package com.bulich.misha.workwithroom.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithroom.db.Categories
import com.bulich.misha.workwithroom.db.CategoriesRepository
import kotlinx.coroutines.launch

class CategoriesViewModel(private val categoriesRepository: CategoriesRepository) : ViewModel() {

    val categories = categoriesRepository.categories

    fun startInsert(nameCategories: String) {
        insert(Categories(0, nameCategories))
    }

    fun startUpdate(idCategories: Int, nameCategories: String) {
        updateCategory(Categories(idCategories, nameCategories))
    }

    fun insert(categories: Categories) = viewModelScope.launch {
        categoriesRepository.insertCategory(categories)
    }

    fun updateCategory(categories: Categories) = viewModelScope.launch {
        categoriesRepository.updateCategory(categories)
    }

    fun deleteCategories(categories: Categories) = viewModelScope.launch {
        categoriesRepository.deleteCategory(categories)
    }

    fun deleteAllCategories() = viewModelScope.launch {
        categoriesRepository.deleteAllCategories()
    }
}