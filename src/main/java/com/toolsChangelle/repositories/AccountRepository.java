package com.toolsChangelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsChangelle.entities.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>{}
