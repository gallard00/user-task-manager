package com.nahuelgallardo.user_task_manager.controller;

import com.nahuelgallardo.user_task_manager.dto.request.AuthRequest;
import com.nahuelgallardo.user_task_manager.dto.request.RegisterRequest;
import com.nahuelgallardo.user_task_manager.dto.response.AuthResponse;
import com.nahuelgallardo.user_task_manager.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse resp = authService.login(request);
        return ResponseEntity.ok(resp);
    }
}
