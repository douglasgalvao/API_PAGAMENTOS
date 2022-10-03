package com.Payment_API.repositories;

import com.Payment_API.entities.user.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserBank, UUID> {
    public Optional<UserBank> findByLogin(String login);
}