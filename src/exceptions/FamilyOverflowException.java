package exceptions;

public class FamilyOverflowException extends RuntimeException {
    private int number;

    public int getNumber() {
        return number;
    }

    public FamilyOverflowException(String message, int number) {
        super(message);
        this.number = number;
    }
}
