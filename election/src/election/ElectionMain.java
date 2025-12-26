package election;

import electionException.InvalidLoginDetailsException;
import electionException.InvalidPollException;

import java.util.Scanner;

public class ElectionMain {
    static Company company = new Company();
    static Admin admin = Admin.getAdmin();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String... args){
        print(menu());
        String input = prompt("Choose your choice from the menu above");
        switch (input){
            case "1" -> {


                print("Login as an Admin");
                String name = prompt("Enter your name: ");
                String password = prompt("Enter your password: ");
                try {print(admin.login(name, password));}
                catch (InvalidLoginDetailsException e) { print(e.getMessage());}

                print(adminMenu());
                String choice = prompt("Choose from above menu");
                switch (choice){
                    case "1" -> {print("Change Name");}
                    case "2" -> {print("Change Password");}
                    case "3" -> {print(addEmployeeMenu());
                                String adminChoice = prompt("Enter your choice from above menu");
                                switch (adminChoice) {
                                    case "1" -> {
                                        String employeeName = prompt("What is the employee's name");
                                        admin.addEmployee(company, employeeName);
                                        print(employeeName + "have been successfully added as employee");
                                    }
                                    case "2" -> {
                                        int numberOfEmployee = Integer.parseInt(prompt("How many employee do you want to add"));
                                        String[] namesOfEmployees = new String[numberOfEmployee];
                                        for(int count = 0; count < numberOfEmployee ; count++){
                                            namesOfEmployees[count] = prompt("Enter employee" +  (count + 1) + "name");
                                        }
                                        admin.addEmployee(company, namesOfEmployees, numberOfEmployee);
                                        print("You have successfully added " + numberOfEmployee + " employees");

                                    }
                                    default -> {
                                        print("Invalid Input");
                                    }
                                }


                            }
                    case "4" -> {
                        print("Create poll");
                        String pollName = prompt("What Poll Do You want to create");
                        int pollOptions = Integer.parseInt(prompt("How many Options for the poll"));
                        String[] options = new String[pollOptions];
                        for(int count = 0; count < pollOptions ; count++){
                            options[count] = prompt("Enter option" +  (count + 1));
                        }
                        admin.createPoll(pollName, pollOptions, options ,company);
                        print("You have successfully createad a poll" );
                    }
                    case "5" -> {
                        print("Remove poll");
                        String pollName = prompt("What Poll Do You want to delete");
                        try {
                            admin.deletePoll(pollName, company);
                            print("You have successfully removed " + pollName + " poll");
                        } catch (InvalidPollException e) {print(e.getMessage());}
                    }
                    default -> {print("Invalid Input");}
                }



            }
            case "2" ->  {
                print("Employee");
                print("Login as an Employee");
                String name = prompt("Enter your name: ");
                String employeeId = prompt("Enter your employee ID: ");
                try {print(admin.login(name, employeeId));}
                catch (InvalidLoginDetailsException e) { print(e.getMessage());}

                print(adminMenu());
                String choice = prompt("Choose from above menu");
            }
            case "3" -> {
                print("Exit The App");
            }
            default -> {
                print("Invalid Input");
            }
        }
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static String menu(){
        admin.deleteAllAdminData();
       company.setName("Omotemmy Venture");
       return "Welcome to " + company.getName() + "\n"
               + "Choose Your Choice From The Following\n" +
               "1   ->  Login As Admin\n" +
               "2   ->  Login as Employee\n" +
               "3   ->  Exit The App";

    }
    public static String prompt(String message){
        System.out.print(message + ": ");
        String input =  scanner.nextLine();
        return input;

    }
    public static String adminMenu(){
        String menu = """
                        MENU
                1   ->  Change your name
                2   ->  Change your password
                3   ->  Add a new Employee
                4   ->  Create a Poll
                5   ->  Remove Poll
                
                """;
        return menu;
    }

    public static String addEmployeeMenu() {
        String menu = """
                        MENU
                1   ->  Add one employee
                2   ->  Add more than one employee
                """;
        return menu;
    }

    public static String employeeMenu(){
        String menu = """
                        MENU
                1   ->  View Available Poll
                2   ->  Cast A vote
                3   ->  View Notifications
                4   ->  Delete Notification
                """;
        return menu;
    }
}
