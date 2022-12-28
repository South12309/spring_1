package com.gb.lesson_7.security;

import com.gb.lesson_7.models.Role;
import com.gb.lesson_7.repositoryes.RoleRepository;
import com.gb.lesson_7.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@RequiredArgsConstructor
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final RoleRepository roleRepository;
    // FIXME: 08.12.2022 Инжектим сюда репозиторий UserRepository
    // FIXME: 08.12.2022 Инжектим сюда репозиторий RoleRepository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.gb.lesson_7.models.User user = userService.getUserByLogin(username);
        // FIXME: 08.12.2022 Загружаем юзера из БД (если его нет, бросает UsernameNotFoundException)
        // FIXME: 08.12.2022 Загружаем роли для юзера из БД
        // FIXME: 08.12.2022 Строим объект типа UserDetails

        return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities("")
                .build();
    }

    private List<GrantedAuthority> getAuthorities(List<Role> roles) {

    }
}
