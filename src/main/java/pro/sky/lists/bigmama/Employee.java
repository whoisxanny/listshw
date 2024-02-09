package pro.sky.lists.bigmama;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private String surname;
    private String name;
    private int salary;
    private int departmentId;
    public int id;
    public static int idCounter = 0;


    public Employee(String surname, String name, Integer salary, Integer departmentId) {
        this.surname = capitalize(surname.toLowerCase());
        this.name = capitalize(name.toLowerCase());
        this.salary = salary;
        this.departmentId = departmentId;
        this.id = ++idCounter;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "Ф.И.О - " + surname + " " + name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname) &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }


    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


