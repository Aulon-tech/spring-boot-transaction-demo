package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {
    private Integer id;
    private String name;
    private AddressDto address;
}
