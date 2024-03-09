package progressive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DenominationConverterTest {

    @Test
    fun `test for USD 87 pennies`() {
        val converter = DenominationConverter()
        val expected = listOf(
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.DIME_COIN,
            Dollar.PENNY_COIN,
            Dollar.PENNY_COIN)
        val actualDenominations = converter.convert(87, "USD")
        assertEquals(expected, actualDenominations)
    }

    @Test
    fun `test for USD 287 pennies`() {
        val converter = DenominationConverter()
        val expected = listOf(
            Dollar.ONE_DOLLAR_NOTE,
            Dollar.ONE_DOLLAR_NOTE,
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.DIME_COIN,
            Dollar.PENNY_COIN,
            Dollar.PENNY_COIN)
        val actualDenominations = converter.convert(287, "USD")
        assertEquals(expected, actualDenominations)
    }

    @Test
    fun `test for EUR 287 cent`() {
        val converter = DenominationConverter()
        val expected = listOf(
            Euro.TWO_EURO_COIN,
            Euro.FIFTY_CENT_COIN,
            Euro.TWENTY_CENT_COIN,
            Euro.TEN_CENT_COIN,
            Euro.FIVE_CENT_COIN,
            Euro.TWO_CENT_COIN)
        val actualDenominations = converter.convert(287, "EUR")
        assertEquals(expected, actualDenominations)
    }

    @Test
    fun `test for GBP`() {
        val converter = DenominationConverter()
        assertThrows<UnsupportedOperationException> {
            converter.convert(287, "GBP")
        }
    }

}
