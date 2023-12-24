package pro.sky.lists;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }
    @Override
    public Employee add(String surName, String name) {
        Employee employee = new Employee(surName, name);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("We already have him");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String surName, String name) {
        Employee employee = new Employee(surName, name);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Who is he?");
    }

    @Override
    public Employee find(String surName, String name) {
        Employee employee = new Employee(surName, name);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Who is he?");
    }

    @Override
    public Collection<Employee> findAll() {
        return new ArrayList<>(employeeList);
    }
}
