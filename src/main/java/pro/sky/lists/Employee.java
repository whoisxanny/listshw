package pro.sky.lists;

import java.util.Objects;

public class Employee {
    private String surname;
    private String name;
    public int id;
    public static int idCounter = 0;


    public Employee(String surname, String name) {
        this.surname = surname;
        this.name = name;
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



}


