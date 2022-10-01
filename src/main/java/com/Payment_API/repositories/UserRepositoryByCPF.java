package com.Payment_API.repositories;

import com.Payment_API.entities.user.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryByCPF extends JpaRepository<UserBank, String> {}