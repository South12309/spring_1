package com.gb.lesson_7.security;

import com.gb.lesson_7.models.Role;
import com.gb.lesson_7.repositoryes.RoleRepository;
import com.gb.lesson_7.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
@Slf4j

public class DatabaseUserDetailsService implements UserDetailsService {
@Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.gb.lesson_7.models.User user = userService.getUserByLogin(username);


        UserDetails userDetails = User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(getAuthorities(user.getRoles()))
                .build();
     //   userDetails.getAuthorities().stream().forEach(s->log.error(s.getAuthority()));

        return userDetails;
    }

    private List<GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role->role.getName())
                .map(SimpleGrantedAuthority::new)
                .map(it -> (GrantedAuthority) it)
                .toList();
    }

}
