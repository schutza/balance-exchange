package progressive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.AssertionError

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
}
