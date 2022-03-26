package banksystem2;

public class MyOwnException extends RuntimeException {
    public MyOwnException(String message) {
        super(message);
    }

    public MyOwnException(String message, Throwable cause) {
        super(message, cause);
    }
}
