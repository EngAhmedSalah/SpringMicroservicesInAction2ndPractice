package com.springmicroservice.project1.userservice.controller;

import com.springmicroservice.project1.userservice.dto.UserRequestDto;
import com.springmicroservice.project1.userservice.entity.User;
import com.springmicroservice.project1.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id)
    {
        if(id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<User> userOptional = userService.getUser(id);
        if(userOptional.isPresent())
            return new ResponseEntity<>(userOptional.get() , HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> usersList = userService.getAllUsers();
        if(!usersList.isEmpty())
            return new ResponseEntity<>(usersList , HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody UserRequestDto user){
        return new ResponseEntity<>(userService.createUser(user) , HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        if(id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<User> userOptional = userService.getUser(id);
        if(userOptional.isPresent()){
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user) , HttpStatus.OK);
    }
}
