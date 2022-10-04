package my.project.mvvm.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.mvvm.domain.useCase.ProductsUseCase

class ProductsViewModel (private val productsUseCase: ProductsUseCase):
        ViewModel() {

        val loadProducts = productsUseCase.loadProducts()

        fun migration(context: Context) = viewModelScope.launch {
            productsUseCase.startMigration(context)
        }



    }
