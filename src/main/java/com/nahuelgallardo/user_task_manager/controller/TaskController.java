package com.nahuelgallardo.user_task_manager.controller;

import com.nahuelgallardo.user_task_manager.dto.request.TaskRequest;
import com.nahuelgallardo.user_task_manager.dto.response.TaskResponse;
import com.nahuelgallardo.user_task_manager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponse create(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable String id, @RequestBody TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/user/{userId}")
    public List<TaskResponse> getByUserId(@PathVariable String userId) {
        return taskService.getTasksByUserId(userId);
    }
}
