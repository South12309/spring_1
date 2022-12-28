package com.gb.lesson_7.repositoryes;

import com.gb.lesson_7.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
