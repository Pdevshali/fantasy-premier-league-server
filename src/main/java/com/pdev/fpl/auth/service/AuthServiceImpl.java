package com.pdev.fpl.auth.service;

import com.pdev.fpl.auth.dtos.AuthResponse;
import com.pdev.fpl.auth.dtos.RegisterReq;
import com.pdev.fpl.users.entities.User;
import com.pdev.fpl.users.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements  AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterReq request) {
        log.info("Register request received");
        if(userRepo.findByEmail(request.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepo.save(user);
        log.info("User registered successfully with email: {}", request.getEmail());

        return new AuthResponse(
                "DUMMY_TOKEN",
                "User registered successfully"
        );
    }

    @Override
    public AuthResponse login(RegisterReq request) {
        log.info("Login request received");
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Invalid email or password");
        }
        log.info("User logged successfully: {}", request.getEmail());

        return new AuthResponse(
                "DUMMY_TOKEN",
                "User logged in successfully"
        );
    }
}
