package electionException;

public class InvalidPassword extends ElectionException {
    public InvalidPassword() {
        super("Password Inputed is Invalid");
    }
}
