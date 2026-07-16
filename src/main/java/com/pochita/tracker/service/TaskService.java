package com.pochita.tracker.service;

import com.pochita.tracker.model.Task;
import com.pochita.tracker.model.User;
import com.pochita.tracker.repository.Taskrepository;
import com.pochita.tracker.repository.Userrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final Taskrepository taskrepository;
    private final UserService userService;

    public TaskService(Taskrepository taskrepository, UserService userservice) {
        this.taskrepository = taskrepository;
        this.userService = userservice;
    }

    public Task createTask(Long userid, Task task) {
        User user = userService.getUserById(userid);
        task.setUser(user);
        return taskrepository.save(task);
    }

    public Task getTaskbyId(Long id) {
        return taskrepository.findById(id).get();
    }

    public List<Task> getTaskByUserId(Long userid) {
        return taskrepository.findByUserId(userid);
    }

    public void deleteTask(Task task){
        Task exsisting = getTaskbyId(task.getId());
        taskrepository.delete(exsisting);
    }

    public List<Task> getAllTasks() {
        return taskrepository.findAll();
    }

    public void UpdateTask(Long id, Task task) {
        Task exisiting = getTaskbyId(id);
        exisiting.setTitle(task.getTitle());
        exisiting.setCompleted(task.isCompleted());
        exisiting.setDiscription(task.getDiscription());
        taskrepository.save(exisiting);
    }



}
