package com.second.damoa.social.repository;

import com.second.damoa.social.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByName(String name);
    Boolean existsByEmail(String email);

}
