package conservative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExchangeEngineTest {

    @Test
    public void shouldThrowWhenInputIsZero() {
        ExchangeEngine engine = new ExchangeEngine("USD");
        Assertions.assertThrows(AssertionError.class, () ->
           engine.exchange(0)
        );
    }

    @Test
    public void shouldThrowWhenInputIsNegative() {
        ExchangeEngine engine = new ExchangeEngine("USD");
        Assertions.assertThrows(AssertionError.class, () ->
            engine.exchange(-1)
        );
    }

    @Test
    public void shouldExchange_USD_87p_intoTheExpectedAmount() {
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

    @Test
    public void shouldExchange_USD_287p_intoTheExpectedAmount() {
        ExchangeEngine engine = new ExchangeEngine("USD");
        List<Models.Denomination> expected = List.of(
                Models.Dollar.ONE_DOLLAR_NOTE,
                Models.Dollar.ONE_DOLLAR_NOTE,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.DIME_COIN,
                Models.Dollar.PENNY_COIN,
                Models.Dollar.PENNY_COIN
        );
        List<Models.Denomination> actual = engine.exchange(287);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shouldExchange_EUR_287ct_intoTheExpectedAmount() {
        ExchangeEngine engine = new ExchangeEngine("EUR");
        List<Models.Denomination> expected = List.of(
                Models.Euro.TWO_EURO_COIN,
                Models.Euro.FIFTY_CENT_COIN,
                Models.Euro.TWENTY_CENT_COIN,
                Models.Euro.TEN_CENT_COIN,
                Models.Euro.FIVE_CENT_COIN,
                Models.Euro.TWO_CENT_COIN);
        List<Models.Denomination> actual = engine.exchange(287);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
