package com.Payment_API.repositories;

import com.Payment_API.entities.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryByCPF extends JpaRepository<UserBank, UUID> {}