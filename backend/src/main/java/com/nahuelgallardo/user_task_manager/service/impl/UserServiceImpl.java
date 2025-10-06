package com.nahuelgallardo.user_task_manager.service.impl;

import com.nahuelgallardo.user_task_manager.dto.request.UserRequest;
import com.nahuelgallardo.user_task_manager.dto.response.UserResponse;
import com.nahuelgallardo.user_task_manager.mapper.UserMapper;
import com.nahuelgallardo.user_task_manager.model.Task;
import com.nahuelgallardo.user_task_manager.model.User;
import com.nahuelgallardo.user_task_manager.repository.TaskRepository;
import com.nahuelgallardo.user_task_manager.repository.UserRepository;
import com.nahuelgallardo.user_task_manager.service.TaskService;
import com.nahuelgallardo.user_task_manager.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserMapper userMapper;
    private final TaskService taskService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TaskRepository taskRepository, TaskService taskService) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.userMapper = userMapper;
        this.taskService = taskService;
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUser(String id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUserById(String userId) {
        // Primero obtengo el usuario
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Si el usuario tiene tareas, las borro una por una
        if (user.getTaskIds() != null && !user.getTaskIds().isEmpty()) {
            for (String taskId : user.getTaskIds()) {
                taskService.deleteTask(taskId);  // Usa el método que ajustamos
            }
        }

        // Finalmente, borro al usuario
        userRepository.deleteById(userId);
    }

    @Override
    public void clearTasksFromUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Limpiar las referencias de las tareas
        user.getTaskIds().clear();
        userRepository.save(user);
    }
}
