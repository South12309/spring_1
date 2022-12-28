package com.gb.lesson_7.api;

import com.gb.lesson_7.models.Role;
import com.gb.lesson_7.models.User;
import com.gb.lesson_7.repositoryes.RoleRepository;
import com.gb.lesson_7.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleService) {
        this.userService = userService;
        this.roleRepository = roleService;
        Role roleAdmin = roleRepository.save(new Role(null, "ROLE_ADMIN"));
        roleRepository.save(new Role(null, "ROLE_USER"));
        for (int i = 1; i < 21; i++) {
            userService.addUser(new User(null,"user" +i, "pass"+i, List.of(roleAdmin)));
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getAllUsers(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
     @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.addUser(user);
    }
     @DeleteMapping("/{id}")
    public void updateUser(@PathVariable int id) {
        userService.deleteUser(id);
    }


}
