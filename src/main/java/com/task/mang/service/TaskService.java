package com.task.mang.service;


import com.task.mang.dto.TaskDTO;
import com.task.mang.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(Task task);
    TaskDTO updateTask(Long id, Task task);
    void deleteTask(Long id);
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getAllTasks();
}
