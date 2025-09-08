package com.nahuelgallardo.user_task_manager.service.impl;

import com.nahuelgallardo.user_task_manager.dto.request.UserRequest;
import com.nahuelgallardo.user_task_manager.dto.response.UserResponse;
import com.nahuelgallardo.user_task_manager.mapper.UserMapper;
import com.nahuelgallardo.user_task_manager.model.Task;
import com.nahuelgallardo.user_task_manager.model.User;
import com.nahuelgallardo.user_task_manager.repository.TaskRepository;
import com.nahuelgallardo.user_task_manager.repository.UserRepository;
import com.nahuelgallardo.user_task_manager.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.userMapper = userMapper;
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
    public void deleteTask(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Buscar todos los usuarios que tengan esta taskId
        List<User> usersWithTask = userRepository.findAll().stream()
                .filter(user -> user.getTaskIds() != null && user.getTaskIds().contains(id))
                .toList();

        // Remover la tarea de cada usuario y guardar
        for (User user : usersWithTask) {
            user.getTaskIds().remove(id);
            userRepository.save(user);
        }

        // Finalmente borrar la tarea
        taskRepository.deleteById(id);
    }
}
