package org.a1aska17.bookhub.repository;

import org.a1aska17.bookhub.entity.Role;
import org.a1aska17.bookhub.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    //Optional<Role> findRoleById(Long idRole);
    Optional<Role> findByRoleName(RoleName roleName);
}
