package com.toolsChangelle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolsChangelle.entities.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
