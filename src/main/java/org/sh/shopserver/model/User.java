package org.sh.shopserver.model;

import jakarta.persistence.*;
import lombok.Data;


import javax.management.relation.Role;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="create_time", nullable = false)
    private LocalDate createTime;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private Role role;

    @Transient
    private String token;
}