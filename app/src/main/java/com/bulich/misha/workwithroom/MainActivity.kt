package com.bulich.misha.workwithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bulich.misha.workwithroom.databinding.ActivityMainBinding
import com.bulich.misha.workwithroom.tabs.CatalogClothes
import com.bulich.misha.workwithroom.tabs.Panel
import com.bulich.misha.workwithroom.tabs.categories.CatalogCategories
import com.bulich.misha.workwithroom.tabs.products.CatalogProducts

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, Panel()).commit()

        binding?.bottomNav?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.panelItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Panel()).commit()
                R.id.catalogProductsItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, CatalogProducts()).commit()
                R.id.catalogClothesItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, CatalogClothes()).commit()
                R.id.catalogCategoriesItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, CatalogCategories()).commit()
            }

            return@setOnItemSelectedListener true
        }
        binding?.bottomNav?.selectedItemId = R.id.panelItemBottomNav
    }
}