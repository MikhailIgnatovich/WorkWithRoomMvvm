package com.bulich.misha.workwithroom.presentation.tabs.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.data.repository.ProductsRepository

class ProductsViewModelFactory(private val productsRepository: ProductsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(productsRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}