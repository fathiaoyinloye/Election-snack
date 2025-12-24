package election;

import electionException.InvalidNoOfEmployees;
import electionException.InvalidPassword;
import electionException.InvalidPollException;
import electionException.NoPollException;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private static Admin onlyInstance;
    private String name;
    private List<Poll> polls;
    private String password;
    private ArrayList<int[]> pollResult;

    private Admin(){
        polls = new ArrayList<>();
        pollResult = new ArrayList<>();
        password = "1234";

    }

    public static Admin getAdmin(){
        if(onlyInstance == null)
            onlyInstance = new Admin();
        return onlyInstance;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(password))     this.password = newPassword;
        else throw new InvalidPassword();

    }

    public Employee addEmployee(Company company, String  name){
        return company.addToEmployee(name);

    }
    public Employee[] addEmployee(Company company, String[]  names, int noOfEmployee){
        Employee[] employees = new Employee[noOfEmployee];

        if(noOfEmployee != names.length) throw new InvalidNoOfEmployees();
        else {
            for (int count = 0; count < noOfEmployee; count++) {
                employees[count] = company.addToEmployee(names[count]);
            }
        }
        return employees;
    }
    public void createPoll(String name, int noOfCandidate, String[] candidates, Company company){
        Poll poll = new Poll(name, noOfCandidate);
        poll.setCandidates(candidates);
        polls.add(poll);
        pollResult.add(new int[noOfCandidate]);
        int noOfEmployee = company.getNoOfEmployees();
        for(int count = 0; count < noOfEmployee; count++){
            company.getEmployees().get(count).addToUnvotedPolls(poll);
        }
    }

    private int getIndex(String name){
        for(int count = 0; count < polls.size(); count++){
            if(polls.get(count).getName().equals(name)) return count;
        }
        return -1;
    }

    public void deletePoll(String name ){
        validate(name);
        pollResult.remove(getIndex(name));
        polls.remove(getIndex(name));

    }
    private void validate(String name){
        if(getIndex(name) == -1) throw new InvalidPollException();
    }
    public void setPollResult(int indexOfPoll, int indexOfCandididate){
        if(!polls.isEmpty()) pollResult.get(indexOfPoll)[indexOfCandididate] += 1;


    }
    public void sendPollNotification(){


    }

    public void viewPoll(){
        if(polls.isEmpty()) throw new NoPollException();
        else {
            for (int count = 0; count < pollResult.size(); count++) {
                System.out.println(polls.get(count));
                for (int counter = 0; counter < pollResult.get(count).length; counter++) {
                    System.out.println(polls.get(count).getCandidates()[counter] + " " + pollResult.get(count)[counter]);
                }
            }
        }
    }
public int getNoOfPolls(){
        return polls.size();
}


}
