package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.model.AppRole;
import com.ecommerce.ecommerce_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);

}
