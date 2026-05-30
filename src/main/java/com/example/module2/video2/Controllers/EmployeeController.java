package com.example.module2.video2.Controllers;

import com.example.module2.video2.dto.EmployeeDto;
import com.example.module2.video2.entities.EmployeeEntity;
import com.example.module2.video2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController
{
//    @GetMapping(path="/secret")
//    public String secret()
//    {
//        return "ABS1258";
//    }
//    @GetMapping(path="/")
//    public String home()
//    {
//        return "Welcome";
//    }

    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path="{id}")
    public EmployeeEntity getEmployee(@PathVariable Long id)
    {
        return employeeRepository.findById(id).orElse(null);
    }
    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                         @RequestParam(required = false) String nws)
    {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee)
    {
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateemp()
    {
        return "Hello from Put";
    }

}


