package com.pdev.fpl.users.dto;

import lombok.Data;

@Data
public class UserCreationRequest {
    private String name;
    private String email;
    private String password;
}
