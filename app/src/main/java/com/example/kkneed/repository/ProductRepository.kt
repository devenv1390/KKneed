package com.example.kkneed.repository

import androidx.lifecycle.LiveData
import com.example.kkneed.datasource.OFFDataSource
import com.example.kkneed.model.Product
import com.example.kkneed.model.ProductDao
import javax.inject.Inject

interface ProductRepository {
    suspend fun getNewProduct(barcode: String): Product
    suspend fun deleteProduct(toDelete: Product)
    fun getAllProduct(): LiveData<List<Product>>
    fun getOneAllProduct(): LiveData<Product>
    fun queryProductCode(barcode: String): Product
}

class ProductRepositoryImp @Inject constructor(
    private val dataSource: OFFDataSource,
    private val productDao: ProductDao,
) : ProductRepository {

    override suspend fun getNewProduct(barcode: String): Product {
        val code = dataSource.getProduct(barcode).code
        val name = dataSource.getProduct(barcode).product.productName
        val picture = dataSource.getProduct(barcode).product.imageUrl
        val brands = dataSource.getProduct(barcode).product.brands
        val product = Product(code, name, picture, brands)
        productDao.insert(product)
        return product
    }

    override suspend fun deleteProduct(toDelete: Product) = productDao.delete(toDelete)

    override fun getAllProduct(): LiveData<List<Product>> = productDao.getAll()
    override fun getOneAllProduct(): LiveData<Product> = productDao.getOne()
    override fun queryProductCode(barcode: String): Product {
        return productDao.queryProductCode(barcode)
    }
}