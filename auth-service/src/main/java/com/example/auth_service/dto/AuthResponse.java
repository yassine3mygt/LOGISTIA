package com.example.auth_service.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String username;
    private String email;
    private List<String> roles;
}