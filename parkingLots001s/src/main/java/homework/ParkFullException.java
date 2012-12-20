package main.java.homework;
public class ParkFullException extends RuntimeException{
    public ParkFullException() {
    }
    public ParkFullException(String message) {
        super(message);
    }
}
