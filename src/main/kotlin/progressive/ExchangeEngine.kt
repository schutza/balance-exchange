package progressive

class ExchangeEngine(private val currency: String) {
    fun exchange(amount: Int): List<Denomination> {
        assert(amount > 0)
        return recExchange(emptyList(), amount)
    }

    private fun recExchange(acc: List<Denomination>, amount: Int): List<Denomination> {
        return when (amount > 0) {
            true -> {
                val nextDenomination = largestDenominationFit(amount)
                recExchange(acc.plus(nextDenomination), amount - nextDenomination.value)
            }
            else -> acc
        }
    }

    private fun largestDenominationFit(amount: Int): Denomination {
        return DenominationSupplier.forCurrency(currency)
            .first { it.value <= amount }
    }
}
