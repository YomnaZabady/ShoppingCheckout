package shopping.checkout.exceptions.fraud;

public class FraudWithMoreThan1500MoneyValue extends Exception {
    public FraudWithMoreThan1500MoneyValue(String errorMessage) {
        super(errorMessage);
    }
}
