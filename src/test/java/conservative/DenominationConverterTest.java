package conservative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DenominationConverterTest {

    private DenominationConverter converter;
    @BeforeEach
    public void setUp() {
        converter = new DenominationConverter();
    }

    @Test
    public void shouldConvert_USD_87pennies_intoExpectedAmount() {
        List<Models.Denomination> expected = List.of(
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.DIME_COIN,
                Models.Dollar.PENNY_COIN,
                Models.Dollar.PENNY_COIN);
        List<Models.Denomination> actualDenominations = converter.convert(87, "USD");
        Assertions.assertEquals(expected, actualDenominations);
    }

    @Test
    public void shouldConvert_USD_287pennies_intoExpectedAmount() {
        List<Models.Denomination> expected = List.of(
                Models.Dollar.ONE_DOLLAR_NOTE,
                Models.Dollar.ONE_DOLLAR_NOTE,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.QUARTER_COIN,
                Models.Dollar.DIME_COIN,
                Models.Dollar.PENNY_COIN,
                Models.Dollar.PENNY_COIN);
        List<Models.Denomination> actualDenominations = converter.convert(287, "USD");
        Assertions.assertEquals(expected, actualDenominations);
    }

    @Test
    public void shouldConvert_EUR_287cent_intoExpectedAmount() {
        List<Models.Denomination> expected = List.of(
                Models.Euro.TWO_EURO_COIN,
                Models.Euro.FIFTY_CENT_COIN,
                Models.Euro.TWENTY_CENT_COIN,
                Models.Euro.TEN_CENT_COIN,
                Models.Euro.FIVE_CENT_COIN,
                Models.Euro.TWO_CENT_COIN);
        List<Models.Denomination> actualDenominations = converter.convert(287, "EUR");
        Assertions.assertEquals(expected, actualDenominations);
    }

    @Test
    public void shouldThrow_GBP() {
        Assertions.assertThrows(UnsupportedOperationException.class, () ->
            converter.convert(287, "GBP")
        );
    }
}
