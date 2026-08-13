package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.RegisterRequest;
import org.a1aska17.bookhub.entity.User;
import org.a1aska17.bookhub.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmailUser(registerRequest.getEmailUser());
        user.setPasswordUser(registerRequest.getPasswordUser());
        return userRepository.save(user);
    }

    public User findUserById(Long idUser) {
        return userRepository.findByIdUser(idUser).orElseThrow(() -> new RuntimeException("Пользователь не найден!"));
    }
}
