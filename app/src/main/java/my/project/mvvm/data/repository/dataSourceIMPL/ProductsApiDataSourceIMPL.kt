package my.project.mvvm.data.repository.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import my.project.mvvm.data.api.ApiClient
import my.project.mvvm.data.models.ProductsApiModel
import my.project.mvvm.data.models.ProductsModel
import my.project.mvvm.data.repository.dataSource.ProductsApiDataSource
import my.project.mvvm.data.repository.dataSource.ProductsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsApiDataSourceIMPL (private val productsDataSource: ProductsDataSource):
    ProductsApiDataSource {



    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.getProduct()
        call?.enqueue(object: Callback<ArrayList<ProductsApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<ProductsApiModel>>,
                response: Response<ArrayList<ProductsApiModel>>
            ) {


                var loadProducts: ArrayList<ProductsApiModel>? = null

                loadProducts?.clear()

                loadProducts = (response.body() as ArrayList<ProductsApiModel>?)!!

                for (audit in loadProducts) {

                    audit.id?.let {
                        ProductsModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString(),
                            audit.category.toString(),
                            audit.price.toString()
                        )
                    }?.let {
                        productsDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "LOADING", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<ProductsApiModel>>, t: Throwable) {
                Toast.makeText(context, "ERROR! CHECK THE INTERNET CONNECTION!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}