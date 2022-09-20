package com.toolsChangelle.repositories;

import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserBank, UUID> {}