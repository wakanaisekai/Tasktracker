package com.pochita.tracker.service;

import com.pochita.tracker.model.User;
import com.pochita.tracker.repository.Userrepository;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {
    private final Userrepository userrepository;
    private final PasswordEncoder passwordencoder;

    public UserService (Userrepository userrepository, PasswordEncoder passwordencoder) {
        this.userrepository = userrepository;
        this.passwordencoder = passwordencoder;
    }

    public User createUser(User user) {
        user.setPassword(passwordencoder.encode(user.getPassword()));
        return userrepository.save(user);
    }

    public List<User> GetAllUsers() {
        return userrepository.findAll();
    }

    public User getUserById(Long userId) {
        return userrepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id" + userId + " not found"));
    }
    public void DeleteUserById(Long userId) {
        userrepository.deleteById(userId);
    }

    public User getUserByUsername(String username) {
        return userrepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User with name" + username + " not found"));
    }
}
