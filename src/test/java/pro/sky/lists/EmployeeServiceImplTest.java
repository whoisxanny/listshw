package pro.sky.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.lists.bigmama.Employee;
import pro.sky.lists.employeeExceptions.EmployeeAlreadyAddedException;
import pro.sky.lists.employeeExceptions.EmployeeNotFoundException;
import pro.sky.lists.employeeExceptions.IlligalArgumentException;
import pro.sky.lists.services.EmployeeService;
import pro.sky.lists.services.EmployeeServiceImpl;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {


    private final EmployeeService e = new EmployeeServiceImpl();

    Employee emp_1 = new Employee("Allanazarov", "Allan", 20000, 1);
    Employee emp_2 = new Employee("Tinkoff", "Oleg", 15000, 1);
    Employee emp_3 = new Employee("Smith", "Adam", 23000, 2);
    Employee emp_validateInput = new Employee("krasniy", "andrey", 20000, 1);


    @Test
    public void shouldAddTheEmployee() {
        Employee expected = emp_1;
        assertFalse(e.findAll().contains(expected));
        Employee actual = e.add(emp_1.getSurname(), emp_1.getName(), emp_1.getSalary(), emp_1.getDepartmentId());
        assertEquals(expected, actual);
        assertTrue(e.validateInput(actual.getName(), actual.getSurname()));
        assertTrue(e.findAll().contains(expected));
    }


    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        Employee actual = e.add(emp_1.getSurname(), emp_1.getName(), emp_1.getSalary(), emp_1.getDepartmentId());
        assertTrue(e.findAll().contains(actual));
        assertThrows(EmployeeAlreadyAddedException.class, () -> e.add(actual.getSurname(), actual.getName(), actual.getSalary(), actual.getDepartmentId()));
    }

    @Test
    public void shouldRemoveTheEmployee() {
        Employee expected = emp_1;
        Employee actual = e.add(emp_1.getSurname(), emp_1.getName(), emp_1.getSalary(), emp_1.getDepartmentId());
        assertTrue(e.findAll().contains(actual));
        assertTrue(e.validateInput(actual.getName(), actual.getSurname()));
        assertEquals(expected, actual);
        e.remove(expected.getSurname(), expected.getName(), expected.getSalary(), expected.getDepartmentId());
        assertFalse(e.findAll().contains(expected));
    }


    @Test
    public void shouldThrowEmployeeNotFoundException() {
        Employee expected = emp_2;
        assertFalse(e.findAll().contains(emp_2));
        assertThrows(EmployeeNotFoundException.class, () -> e.remove(expected.getSurname(), expected.getName(), expected.getSalary(), expected.getDepartmentId()));
    }

    @Test
    public void shouldFindTheEmployee() {
        Employee actual = e.add(emp_1.getSurname(), emp_1.getName(), emp_1.getSalary(), emp_1.getDepartmentId());
        assertTrue(e.validateInput(actual.getName(), actual.getSurname()));
        assertTrue(e.findAll().contains(actual));
        Employee expected = emp_1;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionInMethodFind() {
        Employee expected = emp_2;
        assertFalse(e.findAll().contains(emp_2));
        assertThrows(EmployeeNotFoundException.class, () -> e.find(expected.getSurname(), expected.getName(), expected.getSalary(), expected.getDepartmentId()));
    }

    @Test
    public void ShouldReturnTheCollectionOfEmployeeIfWeHaveThem() {
        Employee emp1 = e.add(emp_1.getSurname(), emp_1.getName(), emp_1.getSalary(), emp_1.getDepartmentId());
        Employee emp2 = e.add(emp_2.getSurname(), emp_2.getName(), emp_2.getSalary(), emp_2.getDepartmentId());
        Collection<Employee> actual = List.of(emp1, emp2);
        Collection<Employee> expected = e.findAll();
        assertEquals(actual.size(),expected.size());
        assertIterableEquals(actual,expected);
    }

    @Test
    public void ShouldReturnTheCollectionOfEmployeeIfWeDontHaveThem() {
        assertEquals(List.of().size(), e.findAll().size());
        assertIterableEquals(List.of(), e.findAll());
    }

}
