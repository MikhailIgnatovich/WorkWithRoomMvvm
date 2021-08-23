package com.bulich.misha.workwithroom.domain.repository

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.models.Products

interface ProductsCall {

    fun loadProducts(): LiveData<List<Products>>

    fun getFilter(nameCategory: String, priceProduct: String):
            LiveData<List<Products>>

    suspend fun insertProduct(products: Products)

    suspend fun updateProduct(products: Products)

    suspend fun deleteProduct(products: Products)

    suspend fun deleteAllProducts()
}