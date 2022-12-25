package com.gb.lesson_7.repositoryes;

import com.gb.lesson_7.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
