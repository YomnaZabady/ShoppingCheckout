package shopping.checkout.exceptions.validations;

public class OrderPriceLessThan100Exception extends Exception {
    public OrderPriceLessThan100Exception(String errorMessage) {
        super(errorMessage);
    }
}
