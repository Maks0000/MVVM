package my.project.mvvm.data.repository.dataSource

import android.content.Context


interface ProductsApiDataSource {

    fun startMigration(context: Context)

}