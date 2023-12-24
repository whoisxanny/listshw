package pro.sky.lists;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public interface EmployeeService {
    Employee add(String surName, String name);
    Employee remove(String surName, String name);
    Employee find(String surName, String name);

    Collection<Employee> findAll();
}
