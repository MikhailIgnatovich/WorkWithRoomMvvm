package com.bulich.misha.workwithroom.tabs.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.CategoryItemBinding
import com.bulich.misha.workwithroom.db.Categories

class CategoriesAdapter(
    private val deleteCategory: (Categories) -> Unit,
    private val editCategory: (Categories) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>() {

    private val categoriesList = ArrayList<Categories>()

    class CategoriesHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            categories: Categories,
            deleteCategory: (Categories) -> Unit,
            editCategories: (Categories) -> Unit
        ) {
            binding.idCategory.text = categories.id.toString()
            binding.nameCategory.text = categories.name

            binding.deleteCategory.setOnClickListener {
                deleteCategory(categories)
            }

            binding.editCategory.setOnClickListener {
                editCategories(categories)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CategoryItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        return CategoriesHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        holder.bind(categoriesList[position], deleteCategory, editCategory)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    fun setList(categories: List<Categories>) {
        categoriesList.clear()
        categoriesList.addAll(categories)
    }
}