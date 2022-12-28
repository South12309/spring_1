package com.gb.lesson_7.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private final JwtRequestFilter filter;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().antMatchers("/auth");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/vi/users/**").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers(HttpMethod.PUT, "/api/vi/users/**").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/vi/users/**").hasAnyRole("ADMIN","SUPERADMIN")
                .antMatchers( "/api/vi/products/**").authenticated()
                .antMatchers( HttpMethod.GET, "/api/vi/users/**").authenticated()
//                .antMatchers(HttpMethod.PUT, "/**").hasAnyRole("ADMIN", "SUPERADMIN", "MANAGER")
//                .antMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN", "SUPERADMIN", "MANAGER")
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().disable()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
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
    public AuthenticationManager authenticationManager(AuthenticationProvider... authenticationProviders) throws Exception {
        return super.authenticationManagerBean();
      //  return new ProviderManager(authenticationProviders);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    //ПРОВАЙДЕР
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        authenticationProvider.setUserDetailsService(userService);
//        return authenticationProvider;
//    }

}
