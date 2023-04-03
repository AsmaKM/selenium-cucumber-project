package utils.test_exceptions;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException(String message) {
        super(message);
        System.out.println(this);
    }

    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(this);
    }
}

