package com.tudo.service.Impl;

import com.tudo.exception.UserNotFoundException;
import com.tudo.model.User;
import com.tudo.repository.UserRepository;
import com.tudo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("User not found with id: " + id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(user.get().getId());
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isEmpty()){
            throw new UserNotFoundException("User not found with id: " + id);
        }
        User updatedUser = existingUser.get();
        updatedUser.setFullName(user.getFullName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());
        updatedUser.setPhone(user.getPhone());

        return userRepository.save(updatedUser);
    }

}
