package com.nahuelgallardo.user_task_manager.dto.response;

import com.nahuelgallardo.user_task_manager.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private List<String> taskIds;
    private Role role;

}
