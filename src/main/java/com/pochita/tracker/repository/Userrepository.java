package com.pochita.tracker.repository;

import com.pochita.tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
