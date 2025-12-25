package election;

import electionException.InvalidLoginDetailsException;

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
                    case "3" -> {print("Add Employee");}
                    case "4" -> {print("Add poll");}
                    case "5" -> {print("Remove poll");}
                    default -> {print("Invalid Input");}
                }



            }
            case "2" ->  {
                print("Employee");
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
                4   ->  Add Poll
                5   ->  Remove Poll
                
                """;
        return menu;
    }
}
