package com.bulich.misha.workwithroom.tabs.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.db.CategoriesRepository

class CategoriesViewModelFactory(private val categoriesRepository: CategoriesRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            return CategoriesViewModel(categoriesRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}