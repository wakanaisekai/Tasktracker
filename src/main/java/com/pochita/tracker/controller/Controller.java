package com.pochita.tracker.controller;

import com.pochita.tracker.model.Task;
import com.pochita.tracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class Controller {
    private final TaskService taskService;
    public Controller(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> findAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTaskbyUserId(@PathVariable Long userId) {
        return taskService.getTaskByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public Task createTask(@RequestBody Task task,@PathVariable Long userId) {
        return taskService.createTask(userId, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(taskService.getTaskbyId(id));
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.UpdateTask(id, task);
    }
}
