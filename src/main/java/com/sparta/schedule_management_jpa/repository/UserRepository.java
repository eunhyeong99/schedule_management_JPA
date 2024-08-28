package com.sparta.schedule_management_jpa.repository;

import com.sparta.schedule_management_jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
    @Query("SELECT r FROM DomainUser r WHERE r.id = :id")
    Optional<User> findById(@Param("id") Long id);
}
