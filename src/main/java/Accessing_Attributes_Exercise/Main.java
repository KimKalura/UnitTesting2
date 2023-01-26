package Accessing_Attributes_Exercise;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Cluj-Napoca", "Republicii", 43);
        Address address2 = new Address("Cluj-Napoca", "Frunzisului", 33);
        Address address3 = new Address("Cluj-Napoca", "Observatorului", 50);
        Address address4 = new Address("Cluj-Napoca", "Eroilor", 72);
        Address address5 = new Address("Cluj-Napoca", "Primaverii", 25);
        Address address6 = new Address("Cluj-Napoca", "Fagului", 3);
        Employee employee1 = new Employee("Andrei", "Popescu", 7500, address1);
        Employee employee2 = new Employee("Ana", "Sandu", 8500, address2);
        Employee employee3 = new Employee("Mihai", "Farcas", 9500, address3);
        Employee employee4 = new Employee("Mihaela", "Ionescu", 10500, address4);
        Employee employee5 = new Employee("Eugen", "Borza", 11500, address5);
        Employee employee6 = new Employee("Alina", "Suciu", 12500, address6);
        Employee[] salesEmployees = new Employee[]{employee1, employee2, employee3};
        Employee[] techEmployees = new Employee[]{employee4, employee5, employee6};
        Department salesDepartment = new Department("sales", salesEmployees, 3);
        Department techDepartment = new Department("tech", techEmployees, 3);
        Department[] companyDepartments = new Department[]{salesDepartment, techDepartment};
        Company company = new Company("JustCodeIT", 2021, companyDepartments, 2);


        //1
        employee1.printEmployeeName();
        //2
        employee2.printEmployeeStreet();
        //3
        employee3.printEmployeeAddress();
        //4
        salesDepartment.printNoOfEmployees();
        techDepartment.printNoOfEmployees();
        //5
        System.out.println("All employees from SALES department are: ");
        salesDepartment.printAllEmployees();
        System.out.println("All employees from TECH department are: ");
        techDepartment.printAllEmployees();

        System.out.println(" ");

        //6
        salesDepartment.printAllEmployeesStreets();
        //7
        //salesDepartment.printEmployeeByName("Farcas");
        System.out.println(salesDepartment.findEmployeeByName("Farcas"));
        //8
        //salesDepartment.printEmployeeAddressByName("Andrei");
        System.out.println(salesDepartment.findEmployeeAddressByName("Popescu"));

        System.out.println(" ");

        //9
        System.out.println(salesDepartment.findEmployeeAddressByStreet("Republicii"));

        System.out.println(" ");

        //10
        company.printAllDepartments();
        //11
        System.out.println("All employees from sales department are: ");
        company.printAllEmployeesByDepartment("sales");

        System.out.println(" ");

        //12
        System.out.println("Number of employees: ");
        company.printNumberOfEmployeesByDepartment("sales");

        System.out.println(" ");

        //14
        company.printEmployeeStreetByDepartment("tech");

        System.out.println(" ");

        //15
        System.out.println(company.printStreetByEmployee("Popescu"));

        //17
        System.out.println(company.findEmployeeByNameDepartment("Popescu", "sales"));

        System.out.println("--------");
        //18
        company.printAllEmployeesFromCompany();

        System.out.println("--------");
        //19
        System.out.println(company.printTotalNumberOfEmployee());

        //20
        System.out.println(company.findEmployeeByName("Suciu"));

        //21
        System.out.println(company.printEmployeeByMaxSalaryFromDepartment("sales"));

        //22
        System.out.println(company.printEmployeeByMaxSalaryFromCompany());

        //23
        System.out.println(company.printEmployeeWithLowestSalaryFromCompany());
    }
}
