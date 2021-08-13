package com.bridgelabz.demoproject.service;

import com.bridgelabz.demoproject.dto.ResponseDTO;
import com.bridgelabz.demoproject.dto.UserDTO;
import com.bridgelabz.demoproject.entity.User;

import java.util.List;

public interface IUserService {

    User addUser(UserDTO userDTO);

    List<User> getUser();

    User updateUser(UserDTO userDTO, int id);

    ResponseDTO deleteUser(int id);
}
