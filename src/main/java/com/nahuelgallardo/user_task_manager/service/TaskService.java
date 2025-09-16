package com.nahuelgallardo.user_task_manager.service;

import com.nahuelgallardo.user_task_manager.dto.request.CreateTaskRequest;
import com.nahuelgallardo.user_task_manager.dto.request.TaskRequest;
import com.nahuelgallardo.user_task_manager.dto.response.TaskResponse;
import com.nahuelgallardo.user_task_manager.model.Task;
import com.nahuelgallardo.user_task_manager.model.TaskStatus;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
    List<TaskResponse> getAllTasks();
    TaskResponse getTaskById(String id);
    TaskResponse updateTask(String id, TaskRequest request);
    void deleteTask(String id);
    List<TaskResponse> getTasksByUserId(String userId);
    TaskResponse createTaskForUser(String userId, CreateTaskRequest request);
    void unassignTaskFromUser(String taskId, String userId);
    Task updateTaskStatus(String id, TaskStatus status);

}
