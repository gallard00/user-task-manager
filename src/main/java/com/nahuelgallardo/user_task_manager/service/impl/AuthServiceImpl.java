package com.nahuelgallardo.user_task_manager.service.impl;

import com.nahuelgallardo.user_task_manager.dto.request.AuthRequest;
import com.nahuelgallardo.user_task_manager.dto.request.RegisterRequest;
import com.nahuelgallardo.user_task_manager.dto.response.AuthResponse;
import com.nahuelgallardo.user_task_manager.model.Role;
import com.nahuelgallardo.user_task_manager.model.User;
import com.nahuelgallardo.user_task_manager.repository.UserRepository;
import com.nahuelgallardo.user_task_manager.security.JwtUtil;
import com.nahuelgallardo.user_task_manager.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User u = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(u);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = jwtUtil.generateToken(auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails
                ? (org.springframework.security.core.userdetails.UserDetails) auth.getPrincipal()
                : null);

        return new AuthResponse(token);
    }
}
