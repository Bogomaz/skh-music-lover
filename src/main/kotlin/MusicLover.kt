fun main() {
    val initialPrice: Double = 50000.0;
    val isRegularCustomer: Boolean = true;

    println("Сумма покупки без скидок составит $initialPrice руб.");
    val discountedPrice = calculateFinalPrice(initialPrice, isRegularCustomer);

    println("Сумма покупки со скидками составит $discountedPrice руб.");
}

/**
 * Рассчитывает итоговую стоимость покупки с учетом всех скидок.
 */
fun calculateFinalPrice(price: Double, isRegularCustomer: Boolean): Double {
    var finalPrice = applyPurchasePriceDiscount(price);
    finalPrice = applyRegularCustomerDiscount(finalPrice, isRegularCustomer);
    return finalPrice;
}

/**
 * Применяет скидки, зависящие от стоимости покупки.
 */
fun applyPurchasePriceDiscount(price: Double): Double {
    return when {
        price <= 1_000 -> price;
        price <= 10_000 -> price - 100;
        else -> price * 0.95; // 5% скидка
    }
}
/**
 * Применяет скидки для постоянных клиентов
 */
fun applyRegularCustomerDiscount(price: Double, isRegularCustomer: Boolean): Double{
    return if(isRegularCustomer) price - price * 0.01 else price;
}
