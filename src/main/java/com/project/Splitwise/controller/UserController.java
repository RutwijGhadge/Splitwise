package com.project.Splitwise.controller;

import com.project.Splitwise.DTO.UserDTO;
import com.project.Splitwise.Exception.UserNotFoundException;
import com.project.Splitwise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //fetching user info with the help of UserID
    @GetMapping("/{userId}/getUser")
    public ResponseEntity getUserById(@PathVariable int userId) throws UserNotFoundException {
        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
