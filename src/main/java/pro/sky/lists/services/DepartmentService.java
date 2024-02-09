package pro.sky.lists.services;

import org.springframework.stereotype.Service;
import pro.sky.lists.bigmama.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@Service
public interface DepartmentService {

    Employee findEmployeeWithMinSalary(int departmentId);
    Employee findEmployeeWithMaxSalary(int departmentId);

    Map<Integer, List<Employee>> findEmployeeSortedByDepartment();

    Collection<Employee> findEmployeesByDepartment(int departmentId);


}
