package com.springmicroservice.project1.userservice.service;

import com.springmicroservice.project1.userservice.dto.UserRequestDto;
import com.springmicroservice.project1.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
    User createUser(UserRequestDto user);
    User updateUser(User user);
    void deleteUser(Long id);
}
