package com.bulich.misha.workwithroom.db

class CategoriesRepository(private val categoriesDao: CategoriesDao) {

    val categories = categoriesDao.getAllCategories()

    suspend fun insertCategory(categories: Categories) {
        categoriesDao.insertCategory(categories)
    }

    suspend fun updateCategory(categories: Categories) {
        categoriesDao.updateCategory(categories)
    }

    suspend fun deleteCategory(categories: Categories) {
        categoriesDao.deleteCategory(categories)
    }

    suspend fun deleteAllCategories() {
        categoriesDao.deleteAllCategories()
    }
}