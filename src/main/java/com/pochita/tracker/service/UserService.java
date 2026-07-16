package com.pochita.tracker.service;

import com.pochita.tracker.model.User;
import com.pochita.tracker.repository.Userrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Userrepository userrepository;

    public UserService (Userrepository userrepository) {
        this.userrepository = userrepository;
    }

    public User createUser(User user) {
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
