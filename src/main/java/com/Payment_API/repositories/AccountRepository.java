package com.Payment_API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Payment_API.entities.account.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>{}
