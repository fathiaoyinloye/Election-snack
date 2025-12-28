package election;

import java.util.Arrays;
import java.util.List;

public class Poll {
    private int noOfCandidate;
    private String name;
    private String[]  candidates;
    private int noOfVote;

    public Poll(String name, int noOfCandidate){
        this.name = name;
        this.noOfCandidate = noOfCandidate;
        candidates = new String[noOfCandidate];

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfCandidates() {
        return noOfCandidate;
    }

    public void setNoOfCandidate(int noOfCandidates) {
        this.noOfCandidate = noOfCandidates;
    }

    public String[] getCandidates() {
        return candidates;
    }

    public void setCandidates(String[] candidates) {
        for(int count = 0; count < noOfCandidate; count++){
            this.candidates[count] = candidates[count];
        }
    }

    public int getNoOfVote() {
        return noOfVote;
    }

    public void setNoOfVote() {
        noOfVote += 1;
    }

    @Override
    public String toString() {
            StringBuilder candidatePrint = new StringBuilder();
            for(String candidate : candidates){
                candidatePrint.append(candidate + " ");
            }
        return "Poll Name is " + name + "\n" +
                "No of Candidates is " + noOfCandidate + "\n" +
                "Candididates are: " + candidatePrint + "\n";
    }
}
