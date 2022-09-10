package me.kofesst.spring.souvenirstore.repository

import me.kofesst.spring.souvenirstore.database.ProductDto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsRepository : CrudRepository<ProductDto, Long>