package conservative;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExchangeEngine {

    private final String currency;
    public ExchangeEngine(String currency){
        this.currency = currency;
    }

    public List<Models.Denomination> exchange(Integer amount) {
        assert(amount > 0);
        return recExchange(new ArrayList<>(), amount);
    }

    private List<Models.Denomination> recExchange(List<Models.Denomination> accumulator, Integer amount) {
        if (amount > 0) {
            Optional<Models.Denomination> nextDenom = largestDenominationFit(amount);
            Integer valueToSubtract = 0;
            if (nextDenom.isPresent()) {
                accumulator.add(nextDenom.get());
                valueToSubtract = nextDenom.get().getValue();
            }
            return recExchange(accumulator, amount - valueToSubtract);
        } else {
            return accumulator;
        }
    }

    private Optional<Models.Denomination> largestDenominationFit(Integer amount) {
        return DenominationSupplier.forCurrency(currency, DenominationSupplier.SortOrder.DESC)
                .stream().filter( dnm -> dnm.getValue() <= amount ).findFirst();
    }
}
