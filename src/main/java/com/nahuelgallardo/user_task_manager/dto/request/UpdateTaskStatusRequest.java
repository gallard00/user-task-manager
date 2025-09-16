package com.nahuelgallardo.user_task_manager.dto.request;

import com.nahuelgallardo.user_task_manager.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskStatusRequest {
    private TaskStatus status;
}
