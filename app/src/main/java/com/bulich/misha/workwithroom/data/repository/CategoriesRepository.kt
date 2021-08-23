package com.bulich.misha.workwithroom.data.repository

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithroom.data.db.CategoriesDao
import com.bulich.misha.workwithroom.data.models.Categories
import com.bulich.misha.workwithroom.domain.repository.CategoriesCall

class CategoriesRepository(private val categoriesDao: CategoriesDao) : CategoriesCall {

    override fun loadCategories(): LiveData<List<Categories>> {
        return categoriesDao.getAllCategories()
    }

    override suspend fun insertCategory(categories: Categories) {
        categoriesDao.insertCategory(categories)
    }

    override suspend fun updateCategory(categories: Categories) {
        categoriesDao.updateCategory(categories)
    }

    override suspend fun deleteCategory(categories: Categories) {
        categoriesDao.deleteCategory(categories)
    }

    override suspend fun deleteAllCategories() {
        categoriesDao.deleteAllCategories()
    }


}