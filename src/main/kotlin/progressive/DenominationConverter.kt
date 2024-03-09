package progressive

class DenominationConverter {

    fun convert(inputAmount: Int, currency: String): List<Denomination> {
        return try {
            ExchangeEngine(currency).exchange(inputAmount)
        } catch (ex: UnsupportedOperationException) {
            println("This machine only supports US Dollar or Euro. ${ex.message}")
            throw UnsupportedOperationException("This machine only supports US Dollar or Euro.",  ex)
        }
    }
}
