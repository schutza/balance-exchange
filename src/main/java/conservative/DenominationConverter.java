package conservative;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DenominationConverter {

    public Map<Models.Denomination, Long> convert(Integer amount, String currency) {
        try {
            List<Models.Denomination> denominations = new ExchangeEngine(currency).exchange(amount);
            return denominations.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        } catch (UnsupportedOperationException ex) {
            String message = "This machine only supports US Dollar or Euro.";
            System.out.println(message + " " + ex.getMessage());
            throw new UnsupportedOperationException("This machine only supports US Dollar or Euro.",  ex);
        }
    }
}
