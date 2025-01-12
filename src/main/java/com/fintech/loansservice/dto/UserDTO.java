package com.fintech.loansservice.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer age;

    private Double salary;
    private String homeOwnership;
    private Integer employmentMonth;
}