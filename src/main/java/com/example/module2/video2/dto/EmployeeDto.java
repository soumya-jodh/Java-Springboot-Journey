package com.example.module2.video2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String name;
    private String email;
    private Integer age;
    private LocalDate datejoined;
    @JsonProperty("isActive")
    private Boolean isActive;


}


