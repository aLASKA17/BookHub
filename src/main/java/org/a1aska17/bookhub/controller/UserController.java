package org.a1aska17.bookhub.controller;

import lombok.Data;
import org.a1aska17.bookhub.dto.auth.JwtResponse;
import org.a1aska17.bookhub.dto.auth.LoginRequest;
import org.a1aska17.bookhub.dto.user.RegisterRequest;
import org.a1aska17.bookhub.entity.User;
import org.a1aska17.bookhub.service.AuthenticationService;
import org.a1aska17.bookhub.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Data
public class UserController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }

    @GetMapping("/{idUser}")
    public User findUser(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/login")
    public JwtResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return authenticationService.authUser(loginRequest);
    }
}
