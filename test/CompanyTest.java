import election.Admin;
import election.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CompanyTest {
    Company company;
    @BeforeEach
    void setup() {
        company = new Company();
    }

    @Test
    public void testThatCompanyHasANAme() {
        company.setName("Omotemmy Venture");
        assertEquals("Omotemmy Venture", company.getName());

    }
    @Test
    public void testThatCompanyHasNoEmployeeAtDefault() {
        company.setName("Omotemmy Venture");
        assertEquals("Omotemmy Venture", company.getName());
        assertEquals(0, company.getNoOfEmployees());

    }
    @Test
    public void testThatCompanyCanHaveAnAdmin() {
        company.setName("Omotemmy Venture");
        assertEquals("Omotemmy Venture", company.getName());
        Admin admin = Admin.getAdmin();
        company.setAdmin(admin);
        assertNotNull(company.getAdmin());


    }
    @Test
    public void testThatCompanyAdminCanAddEmployee() {
        company.setName("Omotemmy Venture");
        assertEquals("Omotemmy Venture", company.getName());
        Admin admin = Admin.getAdmin();
        company.setAdmin(admin);
        assertNotNull(company.getAdmin());
        company.getAdmin().addEmployee(company, "Fathia");


    }
}
