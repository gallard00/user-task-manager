package com.nahuelgallardo.user_task_manager.service.impl;

import com.nahuelgallardo.user_task_manager.dto.request.CreateTaskRequest;
import com.nahuelgallardo.user_task_manager.dto.request.TaskRequest;
import com.nahuelgallardo.user_task_manager.dto.response.TaskResponse;
import com.nahuelgallardo.user_task_manager.mapper.TaskMapper;
import com.nahuelgallardo.user_task_manager.model.Task;
import com.nahuelgallardo.user_task_manager.model.User;
import com.nahuelgallardo.user_task_manager.repository.TaskRepository;
import com.nahuelgallardo.user_task_manager.repository.UserRepository;
import com.nahuelgallardo.user_task_manager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
    }

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = taskMapper.toEntity(request);
        return taskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getTaskById(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse updateTask(String id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setUserId(request.getUserId());
        return taskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskResponse createTaskForUser(String userId, CreateTaskRequest request) {
        // 1) Validar que exista el usuario
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2) Crear la tarea ya vinculada al usuario
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .completed(false)
                .userId(userId)
                .build();

        Task saved = taskRepository.save(task);

        // 3) Actualizar la lista de taskIds del usuario (si la usás)
        if (user.getTaskIds() == null) {
            user.setTaskIds(new java.util.ArrayList<>());
        }
        user.getTaskIds().add(saved.getId());
        userRepository.save(user);

        // 4) Devolver DTO
        return taskMapper.toResponse(saved);
    }

    @Override
    public List<TaskResponse> getTasksByUserId(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        List<Task> tasks = taskRepository.findByUserId(userId);
        // Usar la instancia taskMapper, no la clase
        return tasks.stream()
                .map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }
}
