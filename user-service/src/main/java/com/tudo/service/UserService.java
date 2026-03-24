package com.tudo.service;

import com.tudo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User updateUser(Long id, User user);
}
