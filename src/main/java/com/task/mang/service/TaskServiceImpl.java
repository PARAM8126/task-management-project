package com.task.mang.service;


import com.task.mang.dto.TaskDTO;
import com.task.mang.entity.Task;
import com.task.mang.entity.User;
import com.task.mang.repository.TaskRepository;
import com.task.mang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskDTO createTask(Task task) {
        try {
            Long userId = task.getUser() != null ? task.getUser().getId() : null;
            if (userId == null) {
                throw new RuntimeException("Task must have a valid user ID");
            }

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

            task.setUser(user);
            task.setCreatedOn(LocalDateTime.now());
            task.setLastUpdatedOn(LocalDateTime.now());
            Task savedTask =  taskRepository.save(task);
            return convertToDto(savedTask);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating task: " + e.getMessage());
        }
    }

    private TaskDTO convertToDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        dto.setStatus(task.getStatus());
        dto.setRemarks(task.getRemarks());
        dto.setCreatedOn(task.getCreatedOn());
        dto.setLastUpdatedOn(task.getLastUpdatedOn());

        if (task.getUser() != null) {
            dto.setUserId(task.getUser().getId());
        }

        if (task.getCreatedOn() != null) {
            dto.setCreatedById(task.getUser().getId());
        }

        return dto;
    }
    private List<TaskDTO> convertToDtoList(List<Task> tasks) {
        return tasks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO updateTask(Long id, Task taskDetails) {
        try {
            Task task = taskRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));

            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDueDate(taskDetails.getDueDate());
            task.setStatus(taskDetails.getStatus());
            task.setRemarks(taskDetails.getRemarks());
            task.setCreatedOn(taskDetails.getCreatedOn());
            task.setLastUpdatedOn(LocalDateTime.now());
            task.setLastUpdatedOn(LocalDateTime.now());

            Task savedTask =  taskRepository.save(task);
            return convertToDto(savedTask);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating task: " + e.getMessage());
        }
    }

    @Override
    public void deleteTask(Long id) {
        try {
            if (!taskRepository.existsById(id)) {
                throw new RuntimeException("Task not found with ID: " + id);
            }
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting task: " + e.getMessage());
        }
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        try {
            Task savedTask = taskRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
            return convertToDto(savedTask);
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving task: " + e.getMessage());
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        try {
            List<Task> savedTask = taskRepository.findAll();
            return convertToDtoList(savedTask);
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving all tasks: " + e.getMessage());
        }
    }
}