package exceptions;

/**
 * Created by Oleksandr Ryzhkov on 10.03.2018.
 */
public class StackSizeExceededException extends Exception {
    public StackSizeExceededException(String message) {
        super(message);
    }
}
