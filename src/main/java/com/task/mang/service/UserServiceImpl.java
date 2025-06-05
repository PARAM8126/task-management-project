package com.task.mang.service;


import com.task.mang.entity.User;
import com.task.mang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating user: " + e.getMessage());
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            return userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving user: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving users: " + e.getMessage());
        }
    }
}