package pro.sky.lists.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.lists.bigmama.Employee;
import pro.sky.lists.services.EmployeeService;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmp(@RequestParam("surname") String surname, @RequestParam("name") String name, @RequestParam("salary") int salary, @RequestParam("departmentId") int departmentId) {
        return employeeService.add(surname, name, salary, departmentId);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmp(@RequestParam("surname") String surname, @RequestParam("name") String name, @RequestParam("salary") int salary, @RequestParam("departmentId") int departmentId) {
        return employeeService.remove(surname, name, salary, departmentId);
    }

    @GetMapping(path = "/find")
    public Employee findEmp(@RequestParam("surname") String surname, @RequestParam("name") String name, @RequestParam("salary") int salary, @RequestParam("departmentId") int departmentId) {
        return employeeService.find(surname, name, salary, departmentId);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }


}
