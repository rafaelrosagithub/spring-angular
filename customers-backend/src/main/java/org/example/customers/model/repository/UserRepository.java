package org.example.customers.model.repository;

import org.example.customers.model.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SystemUser, Integer> {

    Optional<SystemUser> findByUsername(String username);

    boolean existsByUsername(String username);
}
