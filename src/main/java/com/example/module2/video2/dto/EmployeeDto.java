package com.example.module2.video2.dto;

import com.example.module2.video2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Long id;

    @NotBlank(message = "Name is a required field")
    @Size(min = 2, max = 40, message = "Number if letter should be greater than 1 and less than 40")
    private String name;

    @Email
    private String email;

    @Min(value = 18, message = "Age must be at least 18 year old to apply")
    private Integer age;

    @EmployeeRoleValidation
    @NotBlank(message = "Role can't be blank")
    private String role;

    @NotNull(message = "Salary can't be null")
    @PositiveOrZero(message = "Salary can't be negative")
    private Integer salary;

    @PastOrPresent(message = "Incorrect Date(Date can't be in future )")
    private LocalDate datejoined;

//    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;


}


