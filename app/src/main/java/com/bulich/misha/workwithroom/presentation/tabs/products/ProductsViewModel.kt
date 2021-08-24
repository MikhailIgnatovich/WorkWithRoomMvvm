package com.bulich.misha.workwithroom.presentation.tabs.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithroom.data.models.Products
import com.bulich.misha.workwithroom.data.repository.ProductsRepository
import com.bulich.misha.workwithroom.domain.useCase.ProductsUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsUseCase: ProductsUseCase) : ViewModel() {

    val products = productsUseCase.loadProducts()

    fun getFilter (nameCategory:String, priceProduct:String):
            LiveData<List<Products>> {
        return productsUseCase.getFilter(nameCategory, priceProduct)
    }

    fun startInsert(nameProduct:String, categoryProduct:String, priceProduct:String) {
        insertProduct(Products(0,nameProduct, categoryProduct, priceProduct))
    }

    fun startUpdateProduct(idProduct:Int, nameProduct:String, nameCategory:String, priceProduct:String) {
        updateProduct(Products(idProduct, nameProduct, nameCategory, priceProduct))
    }

    fun insertProduct(products: Products) = viewModelScope.launch{

        productsUseCase.insertProduct(products)
    }

    fun updateProduct(products: Products) = viewModelScope.launch{

        productsUseCase.updateProduct(products)
    }

    fun deleteProduct(products: Products) = viewModelScope.launch{

        productsUseCase.deleteProduct(products)
    }

    fun deleteAllProducts() = viewModelScope.launch{

        productsUseCase.deleteAllProducts()
    }
}