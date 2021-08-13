package com.bridgelabz.demoproject.controller;

import com.bridgelabz.demoproject.dto.ResponseDTO;
import com.bridgelabz.demoproject.dto.UserDTO;
import com.bridgelabz.demoproject.entity.User;
import com.bridgelabz.demoproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping (value = "/create")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody @Valid UserDTO userDTO, BindingResult e) {
        if (e.hasErrors()) {
            List<String> error = e.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(new ResponseDTO(error, "Validation Error"),
                    HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.addUser(userDTO);
        return new ResponseEntity<>(new ResponseDTO(userDTO, "User Created Successfully"),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllUsers(){
        List<User> users = this.userService.getUser();
        return new ResponseEntity<>(new ResponseDTO(users, "All Users"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO,
                                                  @PathVariable("id") int id){
        User user = this.userService.updateUser(userDTO, id);
        return new ResponseEntity<>(new ResponseDTO(user,
                "User updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable ("id") int id){
        return new ResponseEntity<ResponseDTO>(this.userService.deleteUser(id), HttpStatus.OK);
    }
}
