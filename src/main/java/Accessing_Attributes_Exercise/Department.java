package Accessing_Attributes_Exercise;

import java.util.Arrays;
import java.util.Objects;

public class Department {

    private String departmentName;

    private Employee[] employees;

    private int numberOfEmployeesInDepartment;

    public Department(String departmentName, Employee[] employees, int numberOfEmployeesInDepartment) {
        this.departmentName = departmentName;
        this.employees = employees;
        this.numberOfEmployeesInDepartment = numberOfEmployeesInDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public int getNumberOfEmployeesInDepartment() {
        return numberOfEmployeesInDepartment;
    }

    public void setNumberOfEmployeesInDepartment(int numberOfEmployeesInDepartment) {
        this.numberOfEmployeesInDepartment = numberOfEmployeesInDepartment;
    }


    //4. scrie un program care afiseaza numarul de angajati din departament
    public void printNoOfEmployees() {
        System.out.println(this.numberOfEmployeesInDepartment);
    }

    //5. scrie o metoda care printeaza toti angajatii din departament
    public void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            //System.out.println(employees[i].getFirstName() + employees[i].getLastName());
            employees[i].printEmployeeName();
        }
    }

    //6. scrie o metoda care printeaza toate strazile adreselor angajatilor din departament
    public void printAllEmployeesStreets() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getAddress().getStreet()); //fara metoda
            //employees[i].printEmployeeStreet(); //cu metoda

        }
    }

    //7. scrie o metoda care cauta un anumit angajat dupa nume in departament, si ii afiseaza numele daca il gaseste
    //void doar afiseaza numele
    /*public void findEmployeeByName(String name){
        for (int i = 0; i < employees.length; i++) {
            if(name.equals(employees[i].getLastName())) {
                System.out.println(employees[i].getLastName());
            }
        }
    }*/

    //returneaza angajatul cu totul pe care l-am gasit; il returnam din functie
    public Employee findEmployeeByName(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (name.equals(employees[i].getLastName())) {
                return employees[i];
            }
        }
        return new Employee("", "", 0, new Address("", "", 0));
    }

    //8. scrie o metoda care printeaza adresa unui anumit angajat din departament
    /*public void findEmployeeAddressByName(String name) {
        for (int i = 0; i < employees.length; i++) {
            if(name.equals(employees[i].getFirstName())) {
                System.out.println(employees[i].getAddress());
            }
        }
    }*/
    /*public Address findEmployeeAddressByName(String name) {
        for (int i = 0; i < employees.length; i++) {
            if(name.equals(employees[i].getLastName())) {
                return employees[i].getAddress();
            }
        }
        return new Address(" ", " ", 0);
    }*/

    public Address findEmployeeAddressByName(String name) {
        Employee foundEmployee = findEmployeeByName(name);
        if (" ".equals(foundEmployee.getLastName())) {
            return new Address(" ", " ", 0);
        }
        return foundEmployee.getAddress();
    }

    //9. scrie o metoda care cauta o adresa (dupa strada) in lista de angajati a departamentului, si ii afiseaza strada daca o gaseste
    public Address findEmployeeAddressByStreet(String street) {
        for (int i = 0; i < employees.length; i++) {
            if (street.equals(employees[i].getAddress().getStreet())) {
                return employees[i].getAddress();
            }
        }
        return new Address(" ", " ", 0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return numberOfEmployeesInDepartment == that.numberOfEmployeesInDepartment && departmentName.equals(that.departmentName) && Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(departmentName, numberOfEmployeesInDepartment);
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + Arrays.toString(employees) +
                ", numberOfEmployeesInDepartment=" + numberOfEmployeesInDepartment +
                '}';
    }
}
