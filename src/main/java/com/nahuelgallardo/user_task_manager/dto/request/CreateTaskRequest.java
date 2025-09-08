package com.nahuelgallardo.user_task_manager.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskRequest {
    private String title;
    private String description;
}
