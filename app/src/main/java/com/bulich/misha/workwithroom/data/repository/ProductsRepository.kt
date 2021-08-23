package com.bulich.misha.workwithroom.data.repository

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.db.ProductsDao
import com.bulich.misha.workwithroom.data.models.Products
import com.bulich.misha.workwithroom.domain.repository.ProductsCall

class ProductsRepository(private val productsDao: ProductsDao) : ProductsCall {

    override fun loadProducts(): LiveData<List<Products>> {
        return productsDao.getAllProducts()
    }

    override fun getFilter(nameCategory: String, priceProduct: String): LiveData<List<Products>> {
        return productsDao.getFilter(nameCategory, priceProduct)
    }

    override suspend fun insertProduct(products: Products) {
        productsDao.insertProduct(products)
    }

    override suspend fun updateProduct(products: Products) {
        productsDao.updateProduct(products)
    }

    override suspend fun deleteProduct(products: Products) {
        productsDao.deleteProduct(products)
    }

    override suspend fun deleteAllProducts() {
        productsDao.deleteAllProducts()
    }


}