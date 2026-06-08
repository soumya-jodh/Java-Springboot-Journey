package com.example.module2.video2.Controllers;

import com.example.module2.video2.dto.EmployeeDto;
import com.example.module2.video2.entities.EmployeeEntity;
import com.example.module2.video2.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @PutMapping(path="/{employeeId}")
    public EmployeeDto updateEmployeeById(@RequestBody EmployeeDto employeeDto, @PathVariable Long employeeId)
    {
        return employeeService.updateEmployeeById(employeeId, employeeDto);
    }

    @DeleteMapping(path="/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path="/{employeeId}")
    public EmployeeDto updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId)
    {
        return employeeService.updateEmployeeById(employeeId, updates);
    }






}


