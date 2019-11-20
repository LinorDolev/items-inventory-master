package exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long itemNumber) {
        super("Could not found item: " + itemNumber);
    }
}
