package progressive

import java.util.*

class DenominationConverter {

    fun convert(inputAmount: Int, currency: String): Map<Denomination, Int> {
        return try {
            ExchangeEngine(currency).exchange(inputAmount).groupingBy { it }.eachCount()
        } catch (ex: UnsupportedOperationException) {
            println("This machine only supports US Dollar or Euro. ${ex.message}")
            throw UnsupportedOperationException("This machine only supports US Dollar or Euro.",  ex)
        }
    }
}
