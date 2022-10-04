package my.project.mvvm.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.mvvm.data.models.ProductsModel

interface ProductsCall {

    fun loadProducts(): LiveData<List<ProductsModel>>
    suspend fun  startMigration(context: Context)
}