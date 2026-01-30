package com.pdev.fpl.users.UserController;


import com.pdev.fpl.users.dto.UserCreationRequest;
import com.pdev.fpl.users.dto.UserResponse;
import com.pdev.fpl.users.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserCreationController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreationRequest user) {
        UserResponse created = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
