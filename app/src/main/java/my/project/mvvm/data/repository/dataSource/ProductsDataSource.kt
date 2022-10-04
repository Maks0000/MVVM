package my.project.mvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import my.project.mvvm.data.models.ProductsModel

interface ProductsDataSource {

    fun insert(productsModel: ProductsModel)

    fun loadProducts(): LiveData<List<ProductsModel>>

    suspend fun clear()
}