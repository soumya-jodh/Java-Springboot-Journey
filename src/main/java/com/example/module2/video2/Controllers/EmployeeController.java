package com.example.module2.video2.Controllers;

import com.example.module2.video2.dto.EmployeeDto;
import com.example.module2.video2.entities.EmployeeEntity;
import com.example.module2.video2.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="{id}")
    public EmployeeDto getEmployee(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeDto> getAllEmployees(@RequestParam(required = false) Integer age,
                         @RequestParam(required = false) String nws)
    {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputEmployee)
    {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping
    public String updateemp()
    {
        return "Hello from Put";
    }

}


