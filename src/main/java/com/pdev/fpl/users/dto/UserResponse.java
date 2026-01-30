package com.pdev.fpl.users.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long  id;
    private String name;
    private String email;
    private LocalDateTime createDate;

}
