package com.example.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public enum RoleName {
        ROLE_ADMIN,
        ROLE_AGENT,
        ROLE_TRANSPORTEUR,
        ROLE_CHAUFFEUR,
        ROLE_CLIENT
    }
}