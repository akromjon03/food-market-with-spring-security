package food_market.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg) {
        super(msg);
    }
}
