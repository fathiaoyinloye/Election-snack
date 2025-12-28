package electionException;

public class NoPollException extends ElectionException {
    public NoPollException() {
        super("There is no poll to vote");
    }
}
