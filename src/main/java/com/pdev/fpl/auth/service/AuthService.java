package com.pdev.fpl.auth.service;

import com.pdev.fpl.auth.dtos.AuthResponse;
import com.pdev.fpl.auth.dtos.RegisterReq;

public interface AuthService {
    AuthResponse register(RegisterReq request);

    AuthResponse login(RegisterReq request);
}
