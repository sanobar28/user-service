package com.bridgelabz.demoproject.service;

import com.bridgelabz.demoproject.dto.ResponseDTO;
import com.bridgelabz.demoproject.dto.UserDTO;
import com.bridgelabz.demoproject.entity.User;
import com.bridgelabz.demoproject.exception.UserException;
import com.bridgelabz.demoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User updateUser(UserDTO userDTO, int id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserException("User Not Found",
                        UserException.ExceptionType.USER_NOT_FOUND));
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setUpdatedDate(LocalDate.now());

        return this.userRepository.save(user);
    }

    @Override
    public ResponseDTO deleteUser(int id) {
        this.userRepository.deleteById(id);
        return new ResponseDTO(id, "User deleted successfully");
    }
}
