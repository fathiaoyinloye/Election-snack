package election;

import electionException.InvalidCandidateException;
import electionException.InvalidPollException;
import electionException.NoPollException;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String id;
    private List<Poll> unvotedPolls;

    public Employee(String name, String id) {
        unvotedPolls = new ArrayList<>();
        this.name = name;
        this.id = id;
    }


    public void castAVote(String nameOfPoll, String candidateChosen, Admin admin){
        Poll poll = findPoll(nameOfPoll);
        String candidate = findCandidate(nameOfPoll, candidateChosen);
        if (!unvotedPolls.isEmpty() && poll != null && candidate != null){
            poll.setNoOfVote();
            findCandidateIndex(nameOfPoll, candidateChosen);
            admin.setPollResult(findPollIndex(nameOfPoll), findCandidateIndex(nameOfPoll, candidateChosen));
            unvotedPolls.remove(poll);


        }
        else if (!unvotedPolls.isEmpty() && poll != null && candidate == null) throw new InvalidCandidateException();
        else if(!unvotedPolls.isEmpty() && poll == null) throw new InvalidPollException();
        else throw new NoPollException();

    }


    public Poll findPoll(String nameOfPoll){
        for (Poll poll : unvotedPolls){
            if(poll.getName().equals(nameOfPoll)) return poll;
        }
        return null;
    }

    public int findCandidateIndex(String nameOfPoll, String name){
        Poll pollChosen = findPoll(nameOfPoll);
        for(int count = 0; count < pollChosen.getNoOfCandidates(); count++){
            if (pollChosen.getCandidates()[count].equals(name))  return count;

        }

        return -1;
    }

    protected int findPollIndex(String nameOfPoll){
        int index = -1;
        for (Poll poll : unvotedPolls){
            index++;
            if(poll.getName().equals(nameOfPoll)) return index;
        }
       return index;
    }

    private String findCandidate(String nameOfPoll, String candidateChosen){
        Poll pollChosen = findPoll(nameOfPoll);
        if (pollChosen != null){
            for(String candidate : pollChosen.getCandidates()){
                if (candidate.equals(candidateChosen)) return candidate;
            }

        }
       return null;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void viewOngoingPollingResult(){

    }

    public void viewUnvotedPoll(){
        if(!unvotedPolls.isEmpty()){
            for (Poll poll : unvotedPolls){
                System.out.println(poll);
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addToUnvotedPolls(Poll poll){
        unvotedPolls.add(poll);
    }

}
