package com.brovko.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "br_email", unique = true, nullable = false, length = 45)
    private String email;

    @Column(name = "br_password", nullable = false, length = 60)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "br_joined_user_roles", joinColumns = @JoinColumn(name = "br_user_fk"), inverseJoinColumns = @JoinColumn(name = "br_role_fk"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
