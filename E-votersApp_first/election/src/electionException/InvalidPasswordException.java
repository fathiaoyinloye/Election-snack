package electionException;

public class InvalidPasswordException extends ElectionException {
    public InvalidPasswordException() {
        super("Password Inputed is Invalid");
    }
}
