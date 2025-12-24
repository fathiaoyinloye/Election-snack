package electionException;

public class InvalidPollException extends ElectionException {
    public InvalidPollException() {
        super("Poll Name Inputed Does Not Exist");
    }
}
