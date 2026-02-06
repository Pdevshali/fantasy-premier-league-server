package com.pdev.fpl.auth.controller;

import com.pdev.fpl.auth.dtos.AuthResponse;
import com.pdev.fpl.auth.dtos.RegisterReq;
import com.pdev.fpl.auth.service.AuthService;
import com.pdev.fpl.common.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
            @RequestBody RegisterReq request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Registration successful",
                        authService.register(request)
                )
        );
    }
}


