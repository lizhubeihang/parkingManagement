package homework;


public class NoCarException extends RuntimeException{
    public NoCarException() {
    }
    public NoCarException(String message) {
        super(message);
    }
}
