package com.bulich.misha.workwithroom.presentation.tabs.categories

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.PanelEditCategoryBinding
import com.bulich.misha.workwithroom.data.repository.CategoriesRepository
import com.bulich.misha.workwithroom.data.db.ProductsDatabase
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class PanelEditCategory : BottomSheetDialogFragment(), View.OnKeyListener {

    private var binding: PanelEditCategoryBinding? = null
    val categoriesViewModel: CategoriesViewModel by viewModel()
    private var idCategory: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.panel_edit_category, container, false)


        binding?.editCategory?.setOnKeyListener(this)
        return binding?.root
    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        when (v.id) {
            R.id.editCategory -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                    categoriesViewModel.startUpdate(
                        idCategory.toString().toInt(),
                        binding?.editCategory?.text?.toString()!!
                    )

                    binding?.editCategory?.setText("")

                    dismiss()

                    (context as FragmentActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.content, CatalogCategories()).commit()

                    return true
                }

            }
        }
        return false
    }
}