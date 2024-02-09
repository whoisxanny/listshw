package pro.sky.lists.services;


import org.springframework.stereotype.Service;
import pro.sky.lists.bigmama.Employee;
import pro.sky.lists.employeeExceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService
                .findAll().stream().filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService
                .findAll().stream().filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeeSortedByDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

}
