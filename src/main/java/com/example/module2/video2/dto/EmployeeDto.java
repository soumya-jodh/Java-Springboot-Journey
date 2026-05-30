package com.example.module2.video2.dto;

import java.time.LocalDate;

public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate datejoined;
    private Boolean isActive;

    public EmployeeDto() {}

    public EmployeeDto(Long id, String name, String email, Integer age, LocalDate datejoined, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.datejoined = datejoined;
        this.isActive = isActive;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatejoined() {
        return datejoined;
    }

    public void setDatejoined(LocalDate datejoined) {
        this.datejoined = datejoined;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}


