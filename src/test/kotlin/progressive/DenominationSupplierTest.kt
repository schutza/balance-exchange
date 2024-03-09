package progressive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import progressive.DenominationSupplier
import progressive.Dollar
import progressive.Euro
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class DenominationSupplierTest {
    @Test
    fun `should equal declared entries for USD`() {
        val sortedDenominationValues = DenominationSupplier.forCurrency("USD")
        assertEquals(Dollar.entries, sortedDenominationValues)
    }

    @Test
    fun `should equal declared entries for EUR`() {
        val sortedDenominationValues = DenominationSupplier.forCurrency("EUR")
        assertEquals(Euro.entries, sortedDenominationValues)
    }

    @Test
    fun `should fail for mismatching denominations`() {
        val sortedDenominationValues = DenominationSupplier.forCurrency("EUR")
        assertNotEquals(Dollar.entries, sortedDenominationValues)
    }

    @Test
    fun `should throw for unsupported currency`() {
        assertThrows<UnsupportedOperationException> {
            DenominationSupplier.forCurrency("GBP")
        }
    }
}
