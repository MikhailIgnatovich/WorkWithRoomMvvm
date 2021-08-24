package com.bulich.misha.workwithroom.presentation.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithroom.data.models.Categories
import com.bulich.misha.workwithroom.data.repository.CategoriesRepository
import com.bulich.misha.workwithroom.domain.useCase.CategoriesUseCase
import kotlinx.coroutines.launch

class CategoriesViewModel(private val categoriesUseCase: CategoriesUseCase) : ViewModel() {

    val categories = categoriesUseCase.loadCategories()

    fun startInsert(nameCategories: String) {
        insert(Categories(0, nameCategories))
    }

    fun startUpdate(idCategories: Int, nameCategories: String) {
        updateCategory(Categories(idCategories, nameCategories))
    }

    fun insert(categories: Categories) = viewModelScope.launch {
        categoriesUseCase.insertCategory(categories)
    }

    fun updateCategory(categories: Categories) = viewModelScope.launch {
        categoriesUseCase.updateCategory(categories)
    }

    fun deleteCategories(categories: Categories) = viewModelScope.launch {
        categoriesUseCase.deleteCategory(categories)
    }

    fun deleteAllCategories() = viewModelScope.launch {
        categoriesUseCase.deleteAllCategories()
    }
}