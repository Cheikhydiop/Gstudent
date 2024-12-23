package com.wane.data.repository;


import com.wane.data.entities.Role;
import com.wane.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends ParentRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);

}