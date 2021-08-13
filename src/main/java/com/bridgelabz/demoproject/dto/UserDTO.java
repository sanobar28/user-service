package com.bridgelabz.demoproject.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class UserDTO {

    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}", message = "Employee name Invalid")
    private String name;
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Invalid Phone Number")
    private String phone;

    private LocalDate createdDate;
    private LocalDate updatedDate;

}
