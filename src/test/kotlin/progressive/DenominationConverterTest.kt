package progressive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DenominationConverterTest {

    @Test
    fun `test for USD 87 pennies`() {
        val converter = DenominationConverter()
        val actualDenominations = converter.convert(87, "USD")
        assertEquals(3, actualDenominations[Dollar.QUARTER_COIN])
        assertEquals(1, actualDenominations[Dollar.DIME_COIN])
        assertEquals(2, actualDenominations[Dollar.PENNY_COIN])
        // assert no other keys
    }

    @Test
    fun `test for USD 287 pennies`() {
        val converter = DenominationConverter()
        val actualDenominations = converter.convert(287, "USD")
        assertEquals(2, actualDenominations[Dollar.ONE_DOLLAR_NOTE])
        assertEquals(3, actualDenominations[Dollar.QUARTER_COIN])
        assertEquals(1, actualDenominations[Dollar.DIME_COIN])
        assertEquals(2, actualDenominations[Dollar.PENNY_COIN])
        // assert no other keys
    }

    @Test
    fun `test for EUR 287 cent`() {
        val converter = DenominationConverter()
        val actualDenominations = converter.convert(287, "EUR")
        assertEquals(1, actualDenominations[Euro.TWO_EURO_COIN])
        assertEquals(1, actualDenominations[Euro.FIFTY_CENT_COIN])
        assertEquals(1, actualDenominations[Euro.TWENTY_CENT_COIN])
        assertEquals(1, actualDenominations[Euro.TEN_CENT_COIN])
        assertEquals(1, actualDenominations[Euro.FIVE_CENT_COIN])
        assertEquals(1, actualDenominations[Euro.TWO_CENT_COIN])
        // assert no other keys
    }

    @Test
    fun `test for GBP`() {
        val converter = DenominationConverter()
        assertThrows<UnsupportedOperationException> {
            converter.convert(287, "GBP")
        }
    }
}
