package my.project.mvvm.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.mvvm.data.localDB.ProductsDao
import my.project.mvvm.data.models.ProductsModel
import my.project.mvvm.data.repository.dataSource.ProductsDataSource

class ProductsDataSourceIMPL (private val dao: ProductsDao):
    ProductsDataSource {


    override fun insert(productsModel: ProductsModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertProduct(productsModel)}
    }

    override fun loadProducts(): LiveData<List<ProductsModel>> {
        return dao.getAllProducts()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}