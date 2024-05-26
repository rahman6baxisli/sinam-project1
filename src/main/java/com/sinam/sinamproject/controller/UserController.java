package com.sinam.sinamproject.controller;

import com.sinam.sinamproject.entity.User;
import com.sinam.sinamproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{fin}")
    public ResponseEntity<User> getUserByFin(@PathVariable String fin) {
        User user = userService.findUserByFin(fin);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/created")
    public  ResponseEntity<User>createUser(@RequestBody User user)
    {
        return null;
    }
}
