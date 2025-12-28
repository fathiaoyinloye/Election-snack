package electionException;

public class InvalidLoginDetailsException extends ElectionException {
    public InvalidLoginDetailsException() {
        super("Invalid Login Details");
    }
}
