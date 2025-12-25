package election;

import java.util.ArrayList;

public class Company {
    private String name;
    private int noOfEmployee;
    private Admin admin;
    private ArrayList <Employee> employees;

    public Company(){
        employees = new ArrayList<>();

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfEmployees() {
        return employees.size();
    }


    public Admin getAdmin() {
        return admin;
    }

    public Employee addToEmployee(String name){
        noOfEmployee++;
        String id = "Emp0";
        if (noOfEmployee < 10) id = id + "0" + noOfEmployee;
        else id = id + noOfEmployee;

        Employee employee = new Employee(name, id);
        employees.add(employee);
        return employee;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }



    public ArrayList<Employee> getEmployees() {

        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
