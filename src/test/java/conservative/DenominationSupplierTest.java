package conservative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DenominationSupplierTest {

    @Test
    public void shouldThrowForInvalidCurrency() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            DenominationSupplier.forCurrency("GBP", DenominationSupplier.SortOrder.DESC);
        });
    }
}
