package com.bulich.misha.workwithroom.domain.useCase

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.models.Products
import com.bulich.misha.workwithroom.domain.repository.ProductsCall

class ProductsUseCase(private val productsCall: ProductsCall) {

     fun loadProducts(): LiveData<List<Products>> {
        return productsCall.loadProducts()
    }

     fun getFilter(nameCategory: String, priceProduct: String): LiveData<List<Products>> {
        return productsCall.getFilter(nameCategory, priceProduct)
    }

     suspend fun insertProduct(products: Products) {
        productsCall.insertProduct(products)
    }

     suspend fun updateProduct(products: Products) {
        productsCall.updateProduct(products)
    }

     suspend fun deleteProduct(products: Products) {
        productsCall.deleteProduct(products)
    }

     suspend fun deleteAllProducts() {
        productsCall.deleteAllProducts()
    }
}