package com.pdev.fpl.auth.dtos;

import lombok.Data;

@Data
public class LoginReq {
    private String email;
    private String password;
}
