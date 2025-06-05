package com.task.mang.controller;

import com.task.mang.dto.TaskDTO;
import com.task.mang.entity.Task;
import com.task.mang.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskDTO createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }
}

