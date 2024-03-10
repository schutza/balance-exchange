package conservative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DenominationSupplierTest {

    @Test
    public void shouldThrowForInvalidCurrency() {
        Assertions.assertThrows(UnsupportedOperationException.class, () ->
            DenominationSupplier.forCurrency("GBP", DenominationSupplier.SortOrder.DESC)
        );
    }
}
