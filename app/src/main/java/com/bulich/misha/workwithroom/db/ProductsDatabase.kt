package com.bulich.misha.workwithroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Categories::class, Products::class], version = 1, exportSchema = false)
abstract class ProductsDatabase: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
    abstract fun products(): ProductsDao

    companion object {
        @Volatile
        private var INSTANCE: ProductsDatabase? = null
        fun getInstance(context: Context): ProductsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductsDatabase::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }
    }
}