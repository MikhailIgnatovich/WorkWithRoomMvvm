package com.bulich.misha.workwithroom.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.CatalogClothesBinding
import com.bulich.misha.workwithroom.db.Products
import com.bulich.misha.workwithroom.db.ProductsDatabase
import com.bulich.misha.workwithroom.db.ProductsRepository
import com.bulich.misha.workwithroom.tabs.products.PanelEditProduct
import com.bulich.misha.workwithroom.tabs.products.ProductsAdapter
import com.bulich.misha.workwithroom.tabs.products.ProductsViewModel
import com.bulich.misha.workwithroom.tabs.products.ProductsViewModelFactory


class CatalogClothes : Fragment() {

    private var binding: CatalogClothesBinding? = null
    private var productsRepository: ProductsRepository? = null
    private var productsViewModel: ProductsViewModel? = null
    private var productsViewModelFactory: ProductsViewModelFactory? = null
    private var productsAdapter: ProductsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.catalog_clothes, container, false)

        val productsDao =
            ProductsDatabase.getInstance((context as FragmentActivity).application).products()
        productsRepository = ProductsRepository(productsDao)
        productsViewModelFactory = ProductsViewModelFactory(productsRepository!!)
        productsViewModel =
            ViewModelProvider(this, productsViewModelFactory!!).get(ProductsViewModel::class.java)

        initRecyclerClothes()

        return binding?.root
    }

    private fun initRecyclerClothes() {
        binding?.recyclerClothes?.layoutManager = LinearLayoutManager(context)
        productsAdapter = ProductsAdapter({ products: Products -> deleteProduct(products) },
            { products: Products -> editProduct(products) })

        displayProducts()
    }

    private fun displayProducts() {
        productsViewModel?.getFilter("одежда", "5000")?.observe(viewLifecycleOwner, Observer {
            productsAdapter?.setList(it)
            productsAdapter?.notifyDataSetChanged()
        })
    }

    private fun editProduct(products: Products) {
        val panelEditProduct = PanelEditProduct()
        val parameters = Bundle()
        parameters.putString("idProduct", products.id.toString())
        parameters.putString("nameProduct", products.name)
        parameters.putString("categoryProduct", products.category)
        parameters.putString("priceProduct", products.price)
        panelEditProduct.arguments = parameters

        panelEditProduct.show((context as FragmentActivity).supportFragmentManager, "editProduct")
    }

    private fun deleteProduct(products: Products) {
        productsViewModel?.deleteProduct(products)
    }
}