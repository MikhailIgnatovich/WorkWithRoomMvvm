package com.bulich.misha.workwithroom.presentation.di

import androidx.room.Room
import com.bulich.misha.workwithroom.data.db.ProductsDatabase
import com.bulich.misha.workwithroom.data.repository.CategoriesRepository
import com.bulich.misha.workwithroom.data.repository.ProductsRepository
import com.bulich.misha.workwithroom.domain.repository.CategoriesCall
import com.bulich.misha.workwithroom.domain.repository.ProductsCall
import com.bulich.misha.workwithroom.domain.useCase.CategoriesUseCase
import com.bulich.misha.workwithroom.domain.useCase.ProductsUseCase
import com.bulich.misha.workwithroom.presentation.tabs.categories.CategoriesViewModel
import com.bulich.misha.workwithroom.presentation.tabs.products.ProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val categoriesModule = module {

    single {
        Room.databaseBuilder(
            androidContext(), ProductsDatabase::class.java,
            "categoriesLocalDB"
        ).build()
    }

    single { get<ProductsDatabase>().categoriesDao() }

    single<CategoriesCall> { CategoriesRepository(get()) }

    single { CategoriesUseCase(get()) }

    viewModel { (CategoriesViewModel(get())) }
}

val productsModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            ProductsDatabase::class.java,
            "productsLocalDB"
        )
    }

    single { get<ProductsDatabase>().productsDao() }

    single<ProductsCall> { ProductsRepository(get()) }

    single { ProductsUseCase(get()) }

    viewModel { ProductsViewModel(get()) }
}