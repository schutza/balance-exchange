package progressive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError
import kotlin.test.assertEquals

class ExchangeEngineTest {

    @Test
    fun `should throw when input is 0`() {
        val engine = ExchangeEngine("USD")
        assertThrows<AssertionError> {
            engine.exchange(0)
        }
    }

    @Test
    fun `should throw when input is negative`() {
        val engine = ExchangeEngine("USD")
        assertThrows<AssertionError> {
            engine.exchange(-1)
        }
    }

    @Test
    fun `test for USD 87 pennies`() {
        val engine = ExchangeEngine("USD")
        val expected = listOf(
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.DIME_COIN,
            Dollar.PENNY_COIN,
            Dollar.PENNY_COIN)
        val actualDenominations = engine.exchange(87)
        assertEquals(expected, actualDenominations)
    }

    @Test
    fun `test for USD 287 pennies`() {
        val engine = ExchangeEngine("USD")
        val expected = listOf(
            Dollar.ONE_DOLLAR_NOTE,
            Dollar.ONE_DOLLAR_NOTE,
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.QUARTER_COIN,
            Dollar.DIME_COIN,
            Dollar.PENNY_COIN,
            Dollar.PENNY_COIN)
        val actualDenominations = engine.exchange(287)
        assertEquals(expected, actualDenominations)
    }

    @Test
    fun `test for EUR 287 cent`() {
        val engine = ExchangeEngine("EUR")
        val expected = listOf(
            Euro.TWO_EURO_COIN,
            Euro.FIFTY_CENT_COIN,
            Euro.TWENTY_CENT_COIN,
            Euro.TEN_CENT_COIN,
            Euro.FIVE_CENT_COIN,
            Euro.TWO_CENT_COIN)
        val actualDenominations = engine.exchange(287)
        assertEquals(expected, actualDenominations)
    }
}
