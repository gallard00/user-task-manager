package com.nahuelgallardo.user_task_manager.mapper;

import com.nahuelgallardo.user_task_manager.dto.request.TaskRequest;
import com.nahuelgallardo.user_task_manager.dto.response.TaskResponse;
import com.nahuelgallardo.user_task_manager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskRequest request) {
        return Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .userId(request.getUserId())
                .build();
    }

    public TaskResponse toResponse(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        response.setUserdId(task.getUserId());
        return response;
    }
}
