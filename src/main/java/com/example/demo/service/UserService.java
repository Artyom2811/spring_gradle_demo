package com.example.demo.service;

import com.example.demo.model.inout.UserIn;
import com.example.demo.model.inout.UserOut;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserOut createUser(UserIn userIn) {
        return userRepository.createUser(userIn);
    }

    public UserOut getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public List<UserOut> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserOut updateUserById(Integer id, UserIn userIn) {
        return userRepository.updateUserById(id, userIn);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteUserById(id);
    }
}
