package com.example.Proyecto.First.Commit.repository;

import com.example.Proyecto.First.Commit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByemail(String email);

    //Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
