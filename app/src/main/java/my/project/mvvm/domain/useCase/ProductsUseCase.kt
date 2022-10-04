package my.project.mvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.mvvm.data.models.ProductsModel
import my.project.mvvm.domain.repository.ProductsCall

class ProductsUseCase (private val productsCall: ProductsCall) {

    fun loadProducts(): LiveData<List<ProductsModel>> {
        return productsCall.loadProducts()

    }

    suspend fun startMigration (context: Context) {

        productsCall.startMigration(context)

    }
}