package me.kofesst.spring.souvenirstore.model

import me.kofesst.spring.souvenirstore.util.format
import java.util.*

data class CustomerOrder(
    val id: Long = 0,
    val orderDate: Date = Date(),
    var status: OrderStatus = OrderStatus.Preparing,
    val customer: Customer = Customer(),
    val point: PickupPoint = PickupPoint(),
    val code: PromoCode? = null,
    val items: List<OrderItem> = emptyList(),
) {
    val itemsPrice: Double
        get() = items.sumOf { it.product.price * it.count }

    val totalPrice: Double
        get() = itemsPrice - itemsPrice * (code?.percent ?: 0.0) / 100

    fun getTimestamp() = orderDate.format("dd.MM.yyyy HH:mm:ss")
}