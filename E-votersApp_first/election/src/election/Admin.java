package election;

import electionException.*;

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
        name = "default";

    }

    public static Admin getAdmin(){
        if(onlyInstance == null)
            onlyInstance = new Admin();
        return onlyInstance;

    }

    public String login(String name, String password) {
        validate(name, password);
        return "You Have Successfully Login";
    }

    private void validate(String name, String password){
        if(!name.equals(this.name) || !password.equals(this.password)) throw new InvalidLoginDetailsException();
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
        else throw new InvalidPasswordException();

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
        if(company.getEmployees().isEmpty()) throw new NoEmployeeException();
        Poll poll = new Poll(name, noOfCandidate);
        poll.setCandidates(candidates);
        polls.add(poll);
        pollResult.add(new int[noOfCandidate]);
        int noOfEmployee = company.getNoOfEmployees();
       Notification notification = sendPollNotification(poll, true);
        for(int count = 0; count < noOfEmployee; count++){
            company.getEmployees().get(count).addToUnvotedPolls(poll);
            company.getEmployees().get(count).addToNotification(notification);


        }
    }

    private int getIndex(String name){
        for(int count = 0; count < polls.size(); count++){
            if(polls.get(count).getName().equals(name)) return count;
        }
        return -1;
    }

    public void deletePoll(String name, Company company){
        validate(name);
        int[] result = pollResult.get(getIndex((name)));
        StringBuilder output = getResult(getPoll(name), result);
        Notification notification = new Notification(getPoll(name), false);
        notification.setResult(output);
        pollResult.remove(getIndex(name));
        int noOfEmployee = company.getNoOfEmployees();
        for(int count = 0; count < noOfEmployee; count++){
            company.getEmployees().get(count).deleteUnvotedPolls(name);
            company.getEmployees().get(count).addToNotification(notification);


        }
        polls.remove(getIndex(name));

    }

    private Poll getPoll(String name){
        return polls.get(getIndex(name));
    }

    private StringBuilder getResult(Poll poll, int[] result){
        StringBuilder output = new StringBuilder();
        for(int count = 0; count < result.length; count++ ){
            output.append(poll.getCandidates()[count] + " Vote is: " + result[count] + " \n");
        }
        return output;
    }

    private void validate(String name){
        if(getIndex(name) == -1) throw new InvalidPollException();
    }
    public void setPollResult(int indexOfPoll, int indexOfCandididate){
        if(!polls.isEmpty()) pollResult.get(indexOfPoll)[indexOfCandididate] += 1;


    }
    public Notification sendPollNotification(Poll poll, boolean addNewPoll){
        return new Notification(poll, addNewPoll);


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
public  void deleteAllAdminData(){
        this.name = "default";
        this.password = "1234";
        if(!polls.isEmpty()) {polls.clear(); pollResult.clear();}
}

}
