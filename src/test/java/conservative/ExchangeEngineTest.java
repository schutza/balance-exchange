package conservative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExchangeEngineTest {

    @Test
    public void shouldThrowWhenInputIsZero() {
        ExchangeEngine engine = new ExchangeEngine("USD");
        Assertions.assertThrows(AssertionError.class, () -> {
           engine.exchange(0);
        });
    }

    @Test
    public void shouldThrowWhenInputIsNegative() {
        ExchangeEngine engine = new ExchangeEngine("USD");
        Assertions.assertThrows(AssertionError.class, () -> {
            engine.exchange(-1);
        });
    }

    @Test
    public void shouldConvertDollarsIntoTheExpectedAmount() {
        ExchangeEngine engine = new ExchangeEngine("USD");
        List<Models.Denomination> expected = List.of(
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.DIME_COIN,
                Models.Dollar.PENNY_COIN,
                Models.Dollar.PENNY_COIN
        );
        List<Models.Denomination> actual = engine.exchange(87);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
