package my.project.mvvm.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import my.project.mvvm.data.models.ProductsModel

@Dao
interface ProductsDao {

    @Insert
    suspend fun insertProduct(productModel: ProductsModel)

    @Query("SELECT * FROM product_data_table")
    fun getAllProducts(): LiveData<List<ProductsModel>>

    @Query("DELETE FROM product_data_table")
    suspend fun clear()

}