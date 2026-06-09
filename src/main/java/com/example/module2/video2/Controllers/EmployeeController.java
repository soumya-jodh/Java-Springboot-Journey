package com.example.module2.video2.Controllers;

import com.example.module2.video2.dto.EmployeeDto;
import com.example.module2.video2.entities.EmployeeEntity;
import com.example.module2.video2.services.EmployeeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id)
    {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);
        return employeeDto
                .map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) Integer age,
                         @RequestParam(required = false) String nws)
    {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto inputEmployee)
    {
        EmployeeDto savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody @Valid EmployeeDto employeeDto, @PathVariable Long employeeId)
    {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDto));
    }

    @DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDto> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                                 @PathVariable Long employeeId) {
        EmployeeDto employeeDto = employeeService.updateEmployeeById(employeeId, updates);
        if (employeeDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDto);
    }






}


