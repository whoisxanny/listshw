package pro.sky.lists.services;

import org.springframework.stereotype.Service;
import pro.sky.lists.bigmama.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public interface EmployeeService {

    Employee add(String surName, String name, int salary, int departmentId);
    Employee remove(String surName, String name, int salary, int departmentId);
    Employee find(String surName, String name, int salary, int departmentId);
    boolean validateInput(String name, String surName);

    Collection<Employee> findAll();
}
