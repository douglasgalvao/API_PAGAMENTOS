package com.Payment_API.services;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.UserBank;
import com.Payment_API.repositories.AccountRepository;
import com.Payment_API.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionServiceTests {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("deve retornar um usuario")
    public void getUserById(){
        UUID id = UUID.fromString("e367d0f8-9113-4c08-86ae-a286ccca30f9");
        UserBank userBank = userService.getUserById(id);
//        Assertions.assertEquals(userRepository.findById(id),userBank);
        System.out.println(userBank);
//        Mockito.when(userRepository.findById(id)).thenReturn(userBank);
        System.out.println("rodou");
    }


}
