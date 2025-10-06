package com.nahuelgallardo.user_task_manager.service;

import com.nahuelgallardo.user_task_manager.dto.request.UserRequest;
import com.nahuelgallardo.user_task_manager.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(String id);
    UserResponse updateUser(String id, UserRequest request);
    void deleteUserById(String userId);
    void clearTasksFromUser(String userId);
}
