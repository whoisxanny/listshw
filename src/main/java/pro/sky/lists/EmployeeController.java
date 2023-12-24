package pro.sky.lists;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmp(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        return employeeService.add(surname, name);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmp(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        return employeeService.remove(surname, name);
    }

    @GetMapping(path = "/find")
    public Employee findEmp(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        return employeeService.find(surname, name);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }


}
