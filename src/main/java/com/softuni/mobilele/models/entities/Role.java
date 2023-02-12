package com.softuni.mobilele.models.entities;

import com.softuni.mobilele.models.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleType getRole() {
        return role;
    }

    public Role setRole(RoleType role) {
        this.role = role;
        return this;
    }
}
