package com.pochita.tracker.repository;

import com.pochita.tracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Taskrepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}
