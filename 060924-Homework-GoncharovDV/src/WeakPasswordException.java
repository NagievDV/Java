public class WeakPasswordException extends Exception {

    public WeakPasswordException() {
        super("Password is too weak.");
    }

    public WeakPasswordException(String message) {
        super(message);
    }
}