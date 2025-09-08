package com.nahuelgallardo.user_task_manager.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    private String title;
    private String description;
    private String userId;
}
