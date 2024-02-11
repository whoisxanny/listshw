package pro.sky.lists.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.lists.bigmama.Employee;
import pro.sky.lists.services.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }


    @GetMapping("/{id}/salary/max")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@PathVariable("id") int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployeeSortedByDepartment();
    }

}
