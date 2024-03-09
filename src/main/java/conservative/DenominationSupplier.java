package conservative;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DenominationSupplier {

    enum SortOrder {
        ASC, DESC
    }
    public static List<Models.Denomination> forCurrency(String currency, SortOrder sortOrder) {
        List<Models.Denomination> denominations = switch (currency) {
            case "USD" -> Arrays.stream(Models.Dollar.values()).collect(Collectors.toList());
            case "EUR" -> Arrays.stream(Models.Euro.values()).collect(Collectors.toList());
            default -> throw new UnsupportedOperationException("Uh Oh!");
        };

        Comparator<Models.Denomination> ascByValue = Comparator.comparingInt(Models.Denomination::getValue);
        Comparator<Models.Denomination> descByValue = ascByValue.reversed();

        if (sortOrder == SortOrder.ASC) {
            return denominations.stream().sorted(ascByValue).collect(Collectors.toList());
        } else {
            return denominations.stream().sorted(descByValue).collect(Collectors.toList());
        }
    }
}
