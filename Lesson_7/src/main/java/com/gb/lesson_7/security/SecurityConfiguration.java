package com.gb.lesson_7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter filter;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().antMatchers("/auth");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers( "/**").authenticated()//.hasAnyRole("ADMIN","SUPERADMIN","MANAGER")
//                .antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN","SUPERADMIN","MANAGER")
//                .antMatchers(HttpMethod.PUT, "/**").hasAnyRole("ADMIN", "SUPERADMIN", "MANAGER")
//                .antMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN", "SUPERADMIN", "MANAGER")
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//                .build();


        return httpSecurity.build();

//        return httpSecurity.authoriz
//                .antMatchers("/api/**").authenticated()
//                .and()
//                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

//        return httpSecurity.authorizeHttpRequests()
//                .requestMatchers("/**").permitAll()
//               // .requestMatchers(HttpMethod.POST, "/**").authenticated()//.hasAnyRole("ADMIN","SUPERADMIN","MANAGER")
////                .requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("ADMIN","SUPERADMIN","MANAGER")
////                .requestMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN","SUPERADMIN","MANAGER")
//                .and()
//                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
//                .build();


    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("pass")
//                .roles("ADMIN", "SUPERADMIN")
//                .build();

   //     return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider... authenticationProviders) {
        return new ProviderManager(authenticationProviders);
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    //ПРОВАЙДЕР
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        authenticationProvider.setUserDetailsService(userService);
//        return authenticationProvider;
//    }

}
