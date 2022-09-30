package com.Payment_API.services;

import com.Payment_API.repositories.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TransactionServiceTests {
    @Autowired
    private TransactionService transactionRepository;

    @Test
    public void shouldThrowCpfExceptionIfCpfIsInvalid(){}

}
