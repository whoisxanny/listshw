package pro.sky.lists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.lists.bigmama.Employee;
import pro.sky.lists.employeeExceptions.EmployeeNotFoundException;
import pro.sky.lists.services.DepartmentServiceImpl;
import pro.sky.lists.services.EmployeeService;

import java.util.*;

import static java.util.Collections.*;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    Employee maxSalary = new Employee("Allanazarov", "Allan", 20000, 1);
    Employee minSalary = new Employee("Tsoy", "Anastasiya", 10000, 1);

    Employee differDepId = new Employee("Tsoy", "Viktoriya", 12000, 2);
    Set<Employee> emps = Set.of(minSalary,differDepId);

    Map<Integer, List<Employee>> differntDeprtmentEmployees = emps.stream().collect(groupingBy(Employee::getDepartmentId));
    int departmentIdOne = 1;
    int departmentIdTwo = 2;
    Map<String, Employee> employees = Map.of(maxSalary.getSurname()+maxSalary.getName(),maxSalary, minSalary.getName()+minSalary.getSurname(),minSalary);

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl e;

    @Test
    public void shouldFindEmployeeWithMaxSalaryInDep() {
        when(employeeService.findAll()).thenReturn(employees.values());
        assertEquals(maxSalary, e.findEmployeeWithMaxSalary(departmentIdOne));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFIndingEmployeeWithMaxSalaryWhenDepIsEmpty() {
        when(employeeService.findAll()).thenReturn(List.of());
        assertThrows(NoSuchElementException.class, () -> e.findEmployeeWithMaxSalary(departmentIdOne));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFIndingEmployeeWithMaxSalaryButBadDepartment() {
        when(employeeService.findAll()).thenReturn(employees.values());
        assertThrows(NoSuchElementException.class, () -> e.findEmployeeWithMaxSalary(departmentIdTwo));
    }


    @Test
    public void shouldFindEmployeeWithMinSalaryInDep() {
        when(employeeService.findAll()).thenReturn(employees.values());
        assertEquals(minSalary, e.findEmployeeWithMinSalary(departmentIdOne));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFIndingEmployeeWithMinSalaryWhenDepIsEmpty() {
        when(employeeService.findAll()).thenReturn(List.of());
        assertThrows(RuntimeException.class, () -> e.findEmployeeWithMinSalary(departmentIdOne));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFIndingEmployeeWithMinSalaryButBadDepartment() {
        when(employeeService.findAll()).thenReturn(employees.values());
        assertThrows(RuntimeException.class, () -> e.findEmployeeWithMinSalary(departmentIdTwo));
    }

    @Test
    public void shouldReturnAllEmployeesSortedByDeps() {
        when(employeeService.findAll()).thenReturn(emps);
        assertEquals(differntDeprtmentEmployees, e.findEmployeeSortedByDepartment());
    }

    @Test
    public void shouldReturnEmptyMapWhenEmployeesDontExist() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), e.findEmployeeSortedByDepartment());

    }

    @Test
    public void shouldReturnEmployeeInCurrectDep() {
        when(employeeService.findAll()).thenReturn(emps);
        assertEquals(singletonList(minSalary), e.findEmployeesByDepartment(departmentIdOne));
        assertEquals(singletonList(differDepId), e.findEmployeesByDepartment(departmentIdTwo));

    }

}
