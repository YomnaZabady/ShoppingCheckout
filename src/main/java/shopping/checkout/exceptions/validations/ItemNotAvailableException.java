package shopping.checkout.exceptions.validations;

public class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String errorMessage) {
        super(errorMessage);
    }
}
