package com.example.demo.controller;

import com.example.demo.model.inout.UserIn;
import com.example.demo.model.inout.UserOut;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOut createUser(@RequestBody UserIn userIn) {
        return userService.createUser(userIn);
    }

    @GetMapping("{id}")
    public UserOut getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserOut> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("{id}")
    public UserOut updateUserById(@PathVariable Integer id, @RequestBody UserIn userIn) {
        return userService.updateUserById(id, userIn);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }
}
