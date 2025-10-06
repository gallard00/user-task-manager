package com.nahuelgallardo.user_task_manager.service;

import com.nahuelgallardo.user_task_manager.dto.request.AuthRequest;
import com.nahuelgallardo.user_task_manager.dto.request.RegisterRequest;
import com.nahuelgallardo.user_task_manager.dto.response.AuthResponse;

public interface AuthService {
    void register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
