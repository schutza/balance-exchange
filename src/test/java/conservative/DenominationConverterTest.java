package conservative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DenominationConverterTest {

    private DenominationConverter converter;
    @BeforeEach
    public void setUp() {
        converter = new DenominationConverter();
    }

    @Test
    public void shouldConvert_USD_87pennies_intoExpectedAmount() {
        Map<Models.Denomination, Long> actualDenominations = converter.convert(87, "USD");
        Assertions.assertEquals(3, actualDenominations.get(Models.Dollar.QUARTER_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Dollar.DIME_COIN));
        Assertions.assertEquals(2, actualDenominations.get(Models.Dollar.PENNY_COIN));
    }

    @Test
    public void shouldConvert_USD_287pennies_intoExpectedAmount() {
        Map<Models.Denomination, Long> actualDenominations = converter.convert(287, "USD");
        Assertions.assertEquals(2, actualDenominations.get(Models.Dollar.ONE_DOLLAR_NOTE));
        Assertions.assertEquals(3, actualDenominations.get(Models.Dollar.QUARTER_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Dollar.DIME_COIN));
        Assertions.assertEquals(2, actualDenominations.get(Models.Dollar.PENNY_COIN));
    }

    @Test
    public void shouldConvert_EUR_287cent_intoExpectedAmount() {
        Map<Models.Denomination, Long> actualDenominations = converter.convert(287, "EUR");
        Assertions.assertEquals(1, actualDenominations.get(Models.Euro.TWO_EURO_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Euro.FIFTY_CENT_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Euro.TWENTY_CENT_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Euro.TEN_CENT_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Euro.FIVE_CENT_COIN));
        Assertions.assertEquals(1, actualDenominations.get(Models.Euro.TWO_CENT_COIN));
    }

    @Test
    public void shouldThrow_GBP() {
        Assertions.assertThrows(UnsupportedOperationException.class, () ->
            converter.convert(287, "GBP")
        );
    }
}
