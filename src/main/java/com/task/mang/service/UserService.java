package com.task.mang.service;


import com.task.mang.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}
