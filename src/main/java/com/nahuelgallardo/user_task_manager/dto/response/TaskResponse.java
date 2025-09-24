package com.nahuelgallardo.user_task_manager.dto.response;

import com.nahuelgallardo.user_task_manager.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private String id;
    private String title;
    private String description;
    private TaskStatus status;
    private String userdId;
}
