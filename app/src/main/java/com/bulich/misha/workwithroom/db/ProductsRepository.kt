package com.bulich.misha.workwithroom.db

import androidx.lifecycle.LiveData

class ProductsRepository(private val productsDao: ProductsDao) {

    val products = productsDao.getAllProducts()

    fun getFilter(nameCategory: String, priceProduct: String):
            LiveData<List<Products>> {
        return productsDao.getFilter(nameCategory, priceProduct)
    }

    suspend fun insertProduct(products: Products) {
        productsDao.insertProduct(products)
    }

    suspend fun updateProduct(products: Products) {
        productsDao.updateProduct(products)
    }

    suspend fun deleteProduct(products: Products) {
        productsDao.deleteProduct(products)
    }

    suspend fun deleteAllProducts() {
        productsDao.deleteAllProducts()
    }


}