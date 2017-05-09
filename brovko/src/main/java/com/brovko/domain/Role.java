package com.brovko.domain;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "br_roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int roleId;

    @Column(name = "br_role", length = 45)
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
