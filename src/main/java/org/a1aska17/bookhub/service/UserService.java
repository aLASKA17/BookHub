package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.user.RegisterRequest;
import org.a1aska17.bookhub.entity.RoleName;
import org.a1aska17.bookhub.entity.User;
import org.a1aska17.bookhub.exception.RoleNotFoundException;
import org.a1aska17.bookhub.exception.UserAlreadyExistsException;
import org.a1aska17.bookhub.exception.UserNotFoundException;
import org.a1aska17.bookhub.repository.RoleRepository;
import org.a1aska17.bookhub.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public User registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByUserEmail(registerRequest.getUserEmail()))  {
            throw new UserAlreadyExistsException("Пользователь с email " + registerRequest.getUserEmail() + " уже сущесвует!");
        }
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setUserEmail(registerRequest.getUserEmail());
        user.setUserPassword(passwordEncoder.encode(registerRequest.getUserPassword()));
        user.getRoles().add(roleRepository.findByRoleName(RoleName.USER)
                .orElseThrow(() -> new RoleNotFoundException("Роль с навзанием " + RoleName.USER + " не найдена!")));
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("Пользователь с Id " + userId + " не найден!"));
    }
}
