package com.bridgelabz.demoproject.entity;

import com.bridgelabz.demoproject.dto.UserDTO;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public User (){
    }

    public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.age = userDTO.getAge();
        this.email = userDTO.getEmail();
        this.phone = userDTO.getPhone();
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }
}
