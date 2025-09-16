package com.nahuelgallardo.user_task_manager.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private String id;
    private String title;
    private String description;
    private String userdId;
}
