package com.bulich.misha.workwithroom.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bulich.misha.workwithroom.data.models.Categories
import com.bulich.misha.workwithroom.data.models.Products

@Database(entities = [Categories::class, Products::class], version = 1, exportSchema = false)
abstract class ProductsDatabase: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
    abstract fun productsDao(): ProductsDao

//    companion object {
//        @Volatile
//        private var INSTANCE: ProductsDatabase? = null
//        fun getInstance(context: Context): ProductsDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        ProductsDatabase::class.java,
//                        "database"
//                    ).build()
//                }
//                return instance
//            }
//        }
//    }
}