package com.flabapp.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flabapp.User.dto.UserDto;
import com.flabapp.User.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("all")
    public ResponseEntity<Object> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("save")
    public ResponseEntity<Object> addUser(@RequestBody @Valid UserDto userDto) {
        return userService.addUser(userDto);
    }
}
