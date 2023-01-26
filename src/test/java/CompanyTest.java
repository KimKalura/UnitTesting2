import Accessing_Attributes_Exercise.Company;
import Accessing_Attributes_Exercise.Department;
import Accessing_Attributes_Exercise.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyTest {

    @Test
    void testAddDepartment_ShouldReturnTrue() {
        //given
        Department[] departments = new Department[100];
        Company company = new Company("RealPower", 3500, departments, 0);
        Employee[] employees = new Employee[100];
        Department addedDepartent = new Department("tech", employees, 0);
        //when
        boolean result = company.addDepartment(addedDepartent);
        //then
        assertTrue(result);
        assertEquals(1, company.getNumberOfDepartments());
    }

    @Test
    void testFindDepartment_ShouldDepartmentName() {
        //given
        Department department = new Department("tech", new Employee[30], 0);
        Department department1 = new Department("sales", new Employee[30], 0);
        Department[] departments = new Department[]{department, department1};
        Company company = new Company("RealPower", 3500, departments, 0);
        //when
        Department result = company.findDepartmentByName("tech");
        //then
        assertEquals(department, result);
    }

    @Test
    void testFindDepartment_ShouldReturnEmptyDepartment() {
        //given
        Department department = new Department("tech", new Employee[30], 0);
        Department department1 = new Department("sales", new Employee[30], 0);
        Department[] departments = new Department[]{department, department1};
        Company company = new Company("RealPower", 3500, departments, 0);
        //when
        Department result = company.findDepartmentByName("arts");
        //then
        assertEquals(new Department(" ", new Employee[10], 0), result);
    }
}

