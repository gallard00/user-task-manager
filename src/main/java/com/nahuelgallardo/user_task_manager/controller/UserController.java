package com.nahuelgallardo.user_task_manager.controller;

import com.nahuelgallardo.user_task_manager.dto.request.CreateTaskRequest;
import com.nahuelgallardo.user_task_manager.dto.request.UserRequest;
import com.nahuelgallardo.user_task_manager.dto.response.TaskResponse;
import com.nahuelgallardo.user_task_manager.dto.response.UserResponse;
import com.nahuelgallardo.user_task_manager.service.TaskService;
import com.nahuelgallardo.user_task_manager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable String id, @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteTask(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskResponse> getUserTasks(@PathVariable String id) {
        return taskService.getTasksByUserId(id);
    }

    @PostMapping("/{userId}/tasks")
    public TaskResponse createTaskForUser(
            @PathVariable String userId,
            @RequestBody CreateTaskRequest request
    ) {
        return taskService.createTaskForUser(userId, request);
    }

    @DeleteMapping("/{userId}/tasks")
    public ResponseEntity<Void> clearTasks(@PathVariable String userId) {
        userService.clearTasksFromUser(userId);
        return ResponseEntity.noContent().build();
    }
}
