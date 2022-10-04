package my.project.mvvm.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import my.project.mvvm.data.models.ProductsModel

@Database(entities = [ProductsModel::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract val productsDao: ProductsDao

}