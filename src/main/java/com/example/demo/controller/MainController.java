package com.example.demo.controller;

import com.example.demo.inout.UserOut;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserOut getUser() {
        return new UserOut(1, "A", "test_mail");
    }

}
