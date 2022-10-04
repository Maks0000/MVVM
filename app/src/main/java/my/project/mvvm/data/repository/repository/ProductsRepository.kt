package my.project.mvvm.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.mvvm.data.models.ProductsModel
import my.project.mvvm.data.repository.dataSource.ProductsApiDataSource
import my.project.mvvm.data.repository.dataSource.ProductsDataSource
import my.project.mvvm.domain.repository.ProductsCall

class ProductsRepository (private val productsApiDataSource: ProductsApiDataSource,
                          private val productsDataSource: ProductsDataSource
): ProductsCall {

    override fun loadProducts(): LiveData<List<ProductsModel>> {
        return productsDataSource.loadProducts()
    }

    override suspend fun startMigration(context: Context) {
        productsDataSource.clear()
        productsApiDataSource.startMigration(context)
    }

}