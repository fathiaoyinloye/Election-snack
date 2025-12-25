package electionException;

public class NoEmployeeException extends ElectionException {
    public NoEmployeeException() {
        super("No Employee have been added");
    }
}
