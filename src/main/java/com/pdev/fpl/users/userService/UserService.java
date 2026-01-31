package com.pdev.fpl.users.userService;

import com.pdev.fpl.users.dto.UserCreationRequest;
import com.pdev.fpl.users.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserCreationRequest request);

    UserResponse fetchByEmail(String email);
}
