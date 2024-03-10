package conservative;

import java.util.List;

public class DenominationConverter {

    public List<Models.Denomination> convert(Integer amount, String currency) {
        try {
            return new ExchangeEngine(currency).exchange(amount);
        } catch (UnsupportedOperationException ex) {
            String message = "This machine only supports US Dollar or Euro.";
            System.out.println(message + " " + ex.getMessage());
            throw new UnsupportedOperationException("This machine only supports US Dollar or Euro.",  ex);
        }
    }
}
