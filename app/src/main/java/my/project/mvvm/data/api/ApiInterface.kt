package my.project.mvvm.data.api

import my.project.mvvm.data.models.ProductsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("getProducts.php")
    fun getProduct(): Call<ArrayList<ProductsApiModel>>
}