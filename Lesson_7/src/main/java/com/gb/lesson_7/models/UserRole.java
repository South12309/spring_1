package com.gb.lesson_7.models;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "role_id")
    private Long role_id;


}
