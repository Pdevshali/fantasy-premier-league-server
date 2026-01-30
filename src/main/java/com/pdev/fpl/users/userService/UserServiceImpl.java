package com.pdev.fpl.users.userService;

import com.pdev.fpl.users.dto.UserCreationRequest;
import com.pdev.fpl.users.dto.UserResponse;
import com.pdev.fpl.users.entities.User;
import com.pdev.fpl.users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepo.save(user);

        return buildResponse(savedUser);
    }

    private UserResponse buildResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse fetchByEmail(String email) {
        return userRepo.findByEmail(email)
                .map(this::buildResponse)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }
}
