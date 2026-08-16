package org.a1aska17.bookhub.repository;

import org.a1aska17.bookhub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUserId(Long userId);
    boolean existsByUserEmail(String userEmail);
    Optional<User> findByUserEmail(String userEmail);
}
