package my.project.mvvm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import my.project.mvvm.databinding.FragmentProductsBinding
import my.project.mvvm.presentation.viewModel.ProductsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Products : Fragment() {

    private var binding: FragmentProductsBinding? = null
    private var productsAdapter: ProductAdapter? = null
    val productsViewModel: ProductsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductsBinding.inflate(inflater, container, false)

        initRecyclerProducts()

        loadProducts()

        return binding?.root
    }

    private fun initRecyclerProducts() {
        binding?.recyclerProducts?.layoutManager = LinearLayoutManager(context)
        productsAdapter = ProductAdapter()
        binding?.recyclerProducts?.adapter = productsAdapter

    }

    private fun loadProducts() {
        productsViewModel.loadProducts.observe(viewLifecycleOwner, Observer {
            productsAdapter?.setList(it)
            productsAdapter?.notifyDataSetChanged()
        })
    }


}