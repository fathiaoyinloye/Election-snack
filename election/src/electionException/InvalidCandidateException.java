package electionException;

public class InvalidCandidateException extends ElectionException{
    public InvalidCandidateException() {
        super("Candidate inputed is not part of the candidate available for poll chosen");
    }
}
