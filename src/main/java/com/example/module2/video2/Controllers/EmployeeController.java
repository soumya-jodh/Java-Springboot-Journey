package com.example.module2.video2.Controllers;

import com.example.module2.video2.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="employees/")
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

    @GetMapping(path="{id}")
    public EmployeeDto getEmployee(@PathVariable Long id)
    {
        return new  EmployeeDto(id, "Soumya", "soumya@gmail.com", 19, LocalDate.of(2026,10,10), true);
    }
    @GetMapping
    public String getemp(@RequestParam(required = false) Integer age,
                         @RequestParam(required = false) String nws)
    {
        return "Hi age = " + age +" "+ nws;
    }

    @PostMapping
    public String createnewemp(){
        return "Hello from Post";
    }

    @PutMapping
    public String updateemp()
    {
        return "Hello from Put";
    }

}


