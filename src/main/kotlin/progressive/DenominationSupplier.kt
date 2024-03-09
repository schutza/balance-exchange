package progressive

class DenominationSupplier {

    enum class SortOrder {
        ASC, DESC
    }
    companion object {
        fun forCurrency(currency: String, sortOrder: SortOrder? = SortOrder.DESC): List<Denomination> {
            return when (currency) {
                "USD" -> Dollar.entries
                "EUR" -> Euro.entries
                else -> throw UnsupportedOperationException("Unsupported currency: $currency")
            }.let { denominations ->
                when (sortOrder) {
                    SortOrder.DESC -> denominations.sortedByDescending { it.value }
                    SortOrder.ASC -> denominations.sortedBy { it.value }
                    else -> throw UnsupportedOperationException("Unsupported sort order: $sortOrder")
                }
            }
        }
    }
}
