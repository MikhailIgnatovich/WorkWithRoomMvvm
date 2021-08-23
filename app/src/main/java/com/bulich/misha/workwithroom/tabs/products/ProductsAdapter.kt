package com.bulich.misha.workwithroom.tabs.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.ProductsItemBinding
import com.bulich.misha.workwithroom.db.Products

class ProductsAdapter(
    private val deleteProduct: (Products) -> Unit,
    private val editProduct: (Products) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ProductsHolder>() {

    private val productsList = ArrayList<Products>()

    class ProductsHolder(val binding: ProductsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            products: Products,
            deleteProduct: (Products) -> Unit,
            editProduct: (Products) -> Unit
        ) {
            binding.idProduct.text = products.id.toString()
            binding.nameProduct.text = products.name
            binding.categoryProduct.text = products.category
            binding.priceProduct.text = products.price

            binding.deleteProduct.setOnClickListener {
                deleteProduct(products)
            }
            binding.editProduct.setOnClickListener {
                editProduct(products)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ProductsItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.products_item, parent, false)
        return ProductsHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        holder.bind(productsList[position], deleteProduct, editProduct)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun setList(products: List<Products>) {
        productsList.clear()
        productsList.addAll(products)
    }
}