package com.flabapp.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flabapp.User.dto.UserDto;
import com.flabapp.User.entity.User;
import com.flabapp.User.repository.UserRepository;
import com.flabapp.User.utils.ResponseHandler;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public ResponseEntity<Object> getAllUsers() {
        
        List<User> users = userRepository.findAll();

        if(users.isEmpty()) 
            return ResponseHandler.getResponse("No users found!", HttpStatus.NOT_FOUND);
        return ResponseHandler.getResponse("All users", HttpStatus.OK, users);

    }

    public ResponseEntity<Object> addUser(UserDto userDto) {

        if(!userDto.getPassword().equals(userDto.getConfirmedPassword())) {
            return ResponseHandler.getResponse("Confirmed password doesn't match", HttpStatus.BAD_REQUEST);
        }

        try {

            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            user.setPassword(userDto.getPassword());

            userRepository.save(user);

            return ResponseHandler.getResponse("User saved successfully", HttpStatus.CREATED, user);

        } catch(Exception e) {

            return ResponseHandler.getResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    } 
}
