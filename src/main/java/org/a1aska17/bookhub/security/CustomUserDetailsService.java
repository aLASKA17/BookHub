package org.a1aska17.bookhub.security;


import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.entity.User;
import org.a1aska17.bookhub.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String userEmail) {
        User user = userRepository.findByUserEmail(userEmail).orElseThrow(() -> new RuntimeException("Пользователь не найден!"));
        return new CustomUserDetails(user);
    }
}
