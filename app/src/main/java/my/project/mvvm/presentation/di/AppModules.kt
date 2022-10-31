package my.project.mvvm.presentation.di


import androidx.room.Room
import androidx.room.RoomDatabase
import my.project.mvvm.data.localDB.Database
import my.project.mvvm.data.localDB.ProductsDao
import my.project.mvvm.data.models.ProductsApiModel
import my.project.mvvm.data.models.ProductsModel
import my.project.mvvm.data.repository.dataSource.ProductsApiDataSource
import my.project.mvvm.data.repository.dataSource.ProductsDataSource
import my.project.mvvm.data.repository.dataSourceIMPL.ProductsApiDataSourceIMPL
import my.project.mvvm.data.repository.dataSourceIMPL.ProductsDataSourceIMPL
import my.project.mvvm.data.repository.repository.ProductsRepository
import my.project.mvvm.domain.repository.ProductsCall
import my.project.mvvm.domain.useCase.ProductsUseCase
import my.project.mvvm.presentation.viewModel.ProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

val moduleProducts = module {

    single {
        Room.databaseBuilder(androidContext(), Database::class.java,
            "localDB").build()
    }

    single { get<Database>().productsDao }

    single<ProductsDataSource> {
        ProductsDataSourceIMPL(
            get()
        )
    }

    single<ProductsApiDataSource>   {
        ProductsApiDataSourceIMPL(
            get()
        )
    }

    single<ProductsCall> { ProductsRepository(get(),get()) }

    single { ProductsUseCase(get()) }

    viewModel { ProductsViewModel(get()) }
}