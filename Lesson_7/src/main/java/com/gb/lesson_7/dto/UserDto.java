package com.gb.lesson_7.dto;

import com.gb.lesson_7.models.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDto {
    private int id;

    private String login;

    private Collection<Role> roles;

}
