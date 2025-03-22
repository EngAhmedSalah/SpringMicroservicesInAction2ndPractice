package com.springmicroservice.project1.userservice.service;

import com.springmicroservice.project1.userservice.dto.UserRequestDto;
import com.springmicroservice.project1.userservice.entity.User;
import com.springmicroservice.project1.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(UserRequestDto request) {
        User user = new User(request.getFirstName() , request.getLastName() , request.getEmail() , request.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
