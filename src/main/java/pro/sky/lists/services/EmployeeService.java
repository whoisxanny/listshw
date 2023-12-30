package pro.sky.lists.services;

import org.springframework.stereotype.Service;
import pro.sky.lists.bigmama.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee add(String surName, String name);
    Employee remove(String surName, String name);
    Employee find(String surName, String name);

    Collection<Employee> findAll();
}
