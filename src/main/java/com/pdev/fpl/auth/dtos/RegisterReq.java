package com.pdev.fpl.auth.dtos;

import lombok.Data;

@Data
public class RegisterReq {
    private String name;
    private String email;
    private String password;
}
