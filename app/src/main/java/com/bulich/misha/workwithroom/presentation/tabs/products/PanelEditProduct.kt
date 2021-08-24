package com.bulich.misha.workwithroom.presentation.tabs.products

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.bulich.misha.workwithroom.R
import com.bulich.misha.workwithroom.databinding.PanelEditProductBinding
import com.bulich.misha.workwithroom.data.db.ProductsDatabase
import com.bulich.misha.workwithroom.data.repository.ProductsRepository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class PanelEditProduct : BottomSheetDialogFragment(), View.OnClickListener, View.OnKeyListener {

    private var binding: PanelEditProductBinding? = null
    val productsViewModel: ProductsViewModel by viewModel()
    private var idProduct: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.panel_edit_product, container, false)

        idProduct = arguments?.getString("idProduct")?.toInt()
        binding?.editNameProduct?.setText(arguments?.getString("nameProduct"))
        binding?.editCategoryProduct?.setText(arguments?.getString("categoryProduct"))
        binding?.editPriceProduct?.setText(arguments?.getString("priceProduct"))

        binding?.buttonEditProduct?.setOnClickListener(this)

        binding?.editNameProduct?.setOnKeyListener(this)
        binding?.editCategoryProduct?.setOnKeyListener(this)
        binding?.editPriceProduct?.setOnKeyListener(this)



        return binding?.root
    }

    override fun onClick(v: View?) {
        productsViewModel.startUpdateProduct(
            idProduct.toString().toInt(),
            binding?.resEditNameProduct?.text.toString(),
            binding?.resEditCategoryProduct?.text.toString(),
            binding?.resEditPriceProduct?.text.toString()
        )

        dismiss()

        (context as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.content, CatalogProducts()).commit()
    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        when (v.id) {
            R.id.editNameProduct -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                    binding?.resEditNameProduct?.text = binding?.editNameProduct?.text
                    binding?.editNameProduct?.setText("")

                    return true
                }
            }

            R.id.editCategoryProduct -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                    binding?.resEditCategoryProduct?.text = binding?.editCategoryProduct?.text
                    binding?.editCategoryProduct?.setText("")

                    return true
                }
            }

            R.id.editPriceProduct -> {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                    binding?.resEditPriceProduct?.text = binding?.editPriceProduct?.text
                    binding?.editPriceProduct?.setText("")

                    return true
                }
            }
        }
        return false
    }

}