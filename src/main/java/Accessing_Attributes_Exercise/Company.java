package Accessing_Attributes_Exercise;

import java.util.Arrays;

public class Company {

    private String name;
    private int yearFounded;
    private Department[] departments;

    private int numberOfDepartments;

    public Company(String name, int yearFounded, Department[] departments, int numberOfDepartments) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.departments = departments;
        this.numberOfDepartments = numberOfDepartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public int getNumberOfDepartments() {
        return numberOfDepartments;
    }

    public void setNumberOfDepartments(int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }



    //10. scrie o metoda care printeaza toate departamentele din companie
    public void printAllDepartments() {
        for (int i = 0; i < departments.length; i++) {
            System.out.println(departments[i]);
        }
    }

    //11. scrie o metoda care printeaza toti angajatii dintr-un anumit departament din companie
    public Department findDepartmentByName(String nameDepartment) {
        for (int i = 0; i < departments.length; i++) {
            if (nameDepartment.equals(departments[i].getDepartmentName())) {
                return departments[i];
            }
        }
        return new Department(" ", new Employee[10], 0);
    }

    public void printAllEmployeesByDepartment(String nameDepartment) {
        Department foundDepartment = findDepartmentByName(nameDepartment);
//      Employee[] employees = foundDepartment.getEmployees()
//        for (int i = 0; i < employees.length; i++) {
//            System.out.println(employees[i]);
//        }
        for (int i = 0; i < foundDepartment.getEmployees().length; i++) {
            System.out.println(foundDepartment.getEmployees()[i]);
        }

        //VARIANTA 2 fara folosirea metodei findDepartmentByName
        /*for (int i = 0; i < departments.length; i++) {
            if (nameDepartment.equals(departments[i].getDepartmentName())) {
                Department foundDepartmentt = departments[i];
                for (int i = 0; i < foundDepartmentt.getEmployees().length; i++) {
                    System.out.println(foundDepartmentt.getEmployees()[i]);
                }
            }
        }*/

        //test
        /*for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments[i].getEmployees().length; j++) {
                System.out.println(departments[i].getEmployees()[i]);
            }
        }
        // extragem
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
            for (int j = 0; j < currentDepartment.getEmployees().length; j++) {
                System.out.println(currentDepartment.getEmployees()[i]);
            }
        }*/
    }

    //12. scrie o metoda care printeaza cati angajati are un anumit departament din companie
    public void printNumberOfEmployeesByDepartment(String nameDepartment) {
        Department foundDepartment = findDepartmentByName(nameDepartment);
        foundDepartment.printNoOfEmployees();
    }

    //14. scrie o metoda care printeaza toate strazile adreselor angajatilor dintr-un anumit departament din companie
    public void printEmployeeStreetByDepartment(String nameDepartment) {
        Department foundDepartment = findDepartmentByName(nameDepartment);
        for (int i = 0; i < foundDepartment.getEmployees().length; i++) {
            System.out.println(foundDepartment.getEmployees()[i].getAddress().getStreet());
        }
    }

    //15. scrie o metoda care printeaza strada adresei unui anumit angajat din companie
    /*public void printStreetByEmployee(String nameEmployee) {
        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments[j].getEmployees().length; j++) {
                System.out.println(departments[i].getEmployees()[j].getAddress().getStreet());
            }
        }
    }*/

    public String printStreetByEmployee(String nameEmployee) {
        /*for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments[j].getEmployees().length; j++) {
                if (nameEmployee.equals(departments[i].getEmployees()[j].getFirstName())) {
                    return departments[j].getEmployees()[j].getAddress().getStreet();
                }
            }
        }
        return "";*/

        for (int i = 0; i < departments.length; i++) {
            Employee foundEmployee = departments[i].findEmployeeByName(nameEmployee);
            if (!"".equals(foundEmployee.getFirstName())) {
                return foundEmployee.getAddress().getStreet();
            }
        }
        return "";
    }

    //17. scrie o metoda care cauta un angajat (dupa nume) intr-un anumit departament din companie si ii afiseaza numele, daca il gaseste
    public Employee findEmployeeByNameDepartment(String nameEmployee, String nameDepartment) {
       /* for (int i = 0; i < departments.length; i++) {
            if (nameDepartment.equals(departments[i].getDepartmentName())) {
                Department foundDepartment = departments[i];
                for (int j = 0; j < foundDepartment.getEmployees().length; j++) {
                    if(nameEmployee.equals(foundDepartment.getEmployees()[j].getFirstName())) {
                        Employee foundEmployeee = foundDepartment.getEmployees()[j];
                        return foundEmployeee;
                    }
                }
            }
        }
        return new Employee(" ", " ", 0, new Address(" ", " ", 0));*/

        Department foundDepartment = findDepartmentByName(nameDepartment);
        Employee foundEmployee = foundDepartment.findEmployeeByName(nameEmployee);
        if (!"".equals(foundEmployee.getFirstName())) {
            return foundEmployee;
        }
        return new Employee("", "", 0, new Address("", "", 0));
    }

    //18. scrie o metoda care printeaza toti angajatii din toate departamentele din companie
    //vezi 11 -- test
    public void printAllEmployeesFromCompany() {
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
            for (int j = 0; j < currentDepartment.getEmployees().length; j++) {
                System.out.println(currentDepartment.getEmployees()[j]);
            }
        }
    }

    //19. scrie o metoda care printeaza numarul total de angajati din toate departamentele din companie
    public int printTotalNumberOfEmployee() {
        int totalNoOfEmployees = 0;
        for (int i = 0; i < departments.length; i++) {
            totalNoOfEmployees += departments[i].getNumberOfEmployeesInDepartment();
        }
        return totalNoOfEmployees;
    }

    //20. scrie o metoda care cauta un angajat in toate departamentele din companie si ii afiseaza numele, daca il gaseste
    public String findEmployeeByName(String nameEmployee) {
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
            /*for (int j = 0; j < currentDepartment.getEmployees().length; j++) {
                if (currentDepartment.getEmployees()[j].getFirstName().equals(nameEmployee)) {
                    return currentDepartment.getEmployees()[j].getFirstName();
                }
            }*/
            Employee foundEmployee = currentDepartment.findEmployeeByName(nameEmployee);
            if (!"".equals(foundEmployee.getLastName())) {
                return foundEmployee.getLastName();
            }
        }
        return "";
    }


    //21. scrie o metoda care printeaza numele angajatului cu cel mai mare salariu dintr-un anumit departament
    public String printEmployeeByMaxSalaryFromDepartment(String departmentName) {
        Employee maxSalary = new Employee("", "", 0, new Address("", "", 0));
        Department foundDepartment = findDepartmentByName(departmentName);
        for (int i = 0; i < foundDepartment.getEmployees().length; i++) {
            if (maxSalary.getSalary() < foundDepartment.getEmployees()[i].getSalary()) {
                maxSalary = foundDepartment.getEmployees()[i];
            }
        }
        return maxSalary.getFirstName();
    }

    //22. scrie o metoda care printeaza numele angajatului cu cel mai mare salariu din companie
    public String printEmployeeByMaxSalaryFromCompany() {
        Employee maxSalary = new Employee("", "", 0, new Address("", "", 0));
        for (int i = 0; i < departments.length; i++) {
            Employee[] employees = departments[i].getEmployees();
            for (int j = 0; j < employees.length; j++) {
                if (maxSalary.getSalary() < employees[j].getSalary()) {
                    maxSalary = employees[j];
                }
            }
        }
        return maxSalary.getFirstName();
    }

    //23. scrie o metoda care printeaza numele angajatului cu cel mai mic salariu din companie
    public String printEmployeeWithLowestSalaryFromCompany() {
        Employee minSalary = new Employee("", "", Integer.MAX_VALUE, new Address("", "", 0));
        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments[i].getEmployees().length; j++) {
                if (minSalary.getSalary() > departments[i].getEmployees()[j].getSalary()) {
                    minSalary = departments[i].getEmployees()[j];
                }
            }
        }
        return minSalary.getFirstName();
    }

    public boolean addDepartment(Department department) {
        departments[numberOfDepartments] = department;
        numberOfDepartments++;
        return true;
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", departments=" + Arrays.toString(departments) +
                ", numberOfDepartments=" + numberOfDepartments +
                '}';
    }
}
