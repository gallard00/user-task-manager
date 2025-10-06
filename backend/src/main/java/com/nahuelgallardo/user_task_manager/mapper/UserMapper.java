package com.nahuelgallardo.user_task_manager.mapper;

import com.nahuelgallardo.user_task_manager.dto.request.UserRequest;
import com.nahuelgallardo.user_task_manager.dto.response.UserResponse;
import com.nahuelgallardo.user_task_manager.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setTaskIds(user.getTaskIds());
        return response;
    }
}
