package pro.sky.lists.services;

import org.springframework.stereotype.Service;
import pro.sky.lists.bigmama.Employee;
import pro.sky.lists.employeeExceptions.EmployeeAlreadyAddedException;
import pro.sky.lists.employeeExceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new HashMap<>();
    }
    @Override
    public Employee add(String surName, String name, int salary, int departmentId) {
        Employee employee = new Employee(surName, name, salary, departmentId);
        if (employeeList.containsKey(surName + name)) {
            throw new EmployeeAlreadyAddedException("We already have him");
        }
        employeeList.put(surName + name, employee);
        return employee;
    }

    @Override
    public Employee remove(String surName, String name, int salary, int departmentId) {
        Employee employee = new Employee(surName, name, salary, departmentId);
        if (employeeList.containsKey(surName + name)) {
            employeeList.remove(surName + name);
            return employee;
        }
        throw new EmployeeNotFoundException("Who is he?");
    }

    @Override
    public Employee find(String surName, String name, int salary, int departmentId) {
        Employee employee = new Employee(surName, name, salary, departmentId);
        if (employeeList.containsKey(surName + name)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Who is he?");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeList.values());
    }

}
