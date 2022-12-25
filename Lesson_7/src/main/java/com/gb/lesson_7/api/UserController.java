package com.gb.lesson_7.api;

import com.gb.lesson_7.models.User;
import com.gb.lesson_7.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
