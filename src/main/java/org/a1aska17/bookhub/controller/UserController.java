package org.a1aska17.bookhub.controller;

import lombok.Data;
import org.a1aska17.bookhub.dto.RegisterRequest;
import org.a1aska17.bookhub.entity.User;
import org.a1aska17.bookhub.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Data
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody RegisterRequest registerRequest) {
        return userService.addUser(registerRequest);
    }

    @GetMapping("/{idUser}")
    public User findUser(@PathVariable Long idUser) {
        return userService.findUserById(idUser);
    }
}
