import election.Admin;
import election.Company;
import election.Employee;
import electionException.InvalidCandidateException;
import electionException.InvalidNoOfEmployees;
import electionException.InvalidPassword;
import electionException.InvalidPollException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    Admin admin;

    @BeforeEach
    void setup() {
        admin = Admin.getAdmin();
    }

    @Test
    public void testThatOnlyOneInstanceOfAdminCanBeCreated() {
        admin.setName("Fathia");
        assertEquals("Fathia", admin.getName());
        Admin admin2 = Admin.getAdmin();
        assertEquals("Fathia", admin2.getName());

    }

    @Test
    public void testThatAdminCanChangeDefaultPassword() {
        Admin admin = Admin.getAdmin();
        admin.setName("Fathia");
        assertEquals("Fathia", admin.getName());
        admin.changePassword("1234", "3256");
        assertEquals("3256", admin.getPassword());

    }

    @Test
    public void testThatAdminTryToChangePasswordWithInvalidOldPassword_throwInvalidPasswordException() {
        Admin admin = Admin.getAdmin();
        admin.setName("Fathia");
        assertEquals("Fathia", admin.getName());
        assertThrows(InvalidPassword.class , () -> admin.changePassword("780", "3256"));

    }
    @Test
    public void testThatAnAdminCanAddANewEmployee(){
        Company company = new Company();
        admin.addEmployee(company, "Omotemmy");
        assertEquals(1, company.getNoOfEmployees());
    }


    @Test
    public void testThatAnAdminCanAddAEmployeeFirst_employeesAutomaticallyASAnEmployeeId(){
        Company company = new Company();
        Employee first = admin.addEmployee(company, "Omotemmy");
        assertEquals(1, company.getNoOfEmployees());
        assertNotNull(first.getId());
        assertEquals("Emp001", first.getId());
    }

    @Test
    public void testThatAnAdminCanAddAEmployeeFirstandSecond_employeesAutomaticallyASAnEmployeeId(){
        Company company = new Company();
        Employee first = admin.addEmployee(company, "Omotemmy");
        assertEquals(1, company.getNoOfEmployees());
        assertNotNull(first.getId());
        assertEquals("Emp001", first.getId());
        Employee second = admin.addEmployee(company, "Tope");
        assertEquals(2, company.getNoOfEmployees());
        assertNotNull(second.getId());
        assertEquals("Emp002", second.getId());
    }
    @Test
    public void testThatAnAdminCanAddAEmployeeFirstandSecondAtOnce(){
        Company company = new Company();
        String[] names = {"Fathia","Omotemmy", "Bola"};
        Employee[] employees = admin.addEmployee(company, names, 3);
        assertEquals(3, company.getNoOfEmployees());
        assertEquals("Emp003", employees[2].getId());
    }

    @Test
    public void testThatAnAdminTryToAddEmployees_wrongNumberOfEmployees_thowsInvalidNumberOfEmployee(){
        Company company = new Company();
        String[] names = {"Fathia","Omotemmy", "Bola"};
        assertThrows(InvalidNoOfEmployees.class, () -> admin.addEmployee(company, names, 2));
    }
    @Test
    public void testThatAdminCanCreateAPoll(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        assertEquals(1, admin.getNoOfPolls());
        admin.deletePoll("Best Staff");
        assertEquals(0, admin.getNoOfPolls());


    }
    @Test
    public void testThatAdminCanViewPolls(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        assertEquals(1, admin.getNoOfPolls());
        admin.viewPoll();
        admin.deletePoll("Best Staff");
        assertEquals(0, admin.getNoOfPolls());
    }

    @Test
    public void testThatAdminCannotDeleteAnUnExistingPoll(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        assertEquals(1, admin.getNoOfPolls());
        assertThrows(InvalidPollException.class, ()-> admin.deletePoll("Best"));
        admin.deletePoll("Best Staff");
        assertEquals(0, admin.getNoOfPolls());
    }

    @Test
    public void testThatEmployeeCanCastAVote(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        Employee[] employees = admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        assertEquals(1, admin.getNoOfPolls());
        employees[0].castAVote("Best Staff","Tayo", admin);
        admin.deletePoll("Best Staff");
        assertEquals(0, admin.getNoOfPolls());
    }

    @Test
    public void testThatEmployeeCannotCastAVoteIfCandidateNameIsIncorrect(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        Employee[] employees = admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        assertEquals(1, admin.getNoOfPolls());
        assertThrows(InvalidCandidateException.class, () -> employees[0].castAVote("Best Staff","ayo", admin));
        admin.deletePoll("Best Staff");
        assertEquals(0, admin.getNoOfPolls());
    }


    @Test
    public void testThatEmployeeCannotCastAVoteWithTheWrongPollName_ThrowInvalidPollException(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        Employee[] employees = admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        assertEquals(1, admin.getNoOfPolls());
        assertThrows(InvalidPollException.class, () -> employees[0].castAVote("Best","Tayo", admin));
        admin.deletePoll("Best Staff");
        assertEquals(0, admin.getNoOfPolls());
    }

    @Test
    public void testThatCandidateCanViewUnvotedPoll(){
        Company company = new Company();
        assertEquals(0, admin.getNoOfPolls());
        String[] candidateNames = {"Bola", "Tayo"};
        String[] names = {"Fathia","Omotemmy", "Bola", "Bayo"};
        Employee[] employees = admin.addEmployee(company, names, 4);
        admin.createPoll("Best Staff", 2, candidateNames, company);
        admin.createPoll("Fastest", 2, candidateNames, company);
        assertEquals(2, admin.getNoOfPolls());
        //employees[0].viewUnvotedPoll();
        admin.deletePoll("Best Staff");
        assertEquals(1, admin.getNoOfPolls());
        admin.deletePoll("Fastest");
        assertEquals(0, admin.getNoOfPolls());


    }
}

