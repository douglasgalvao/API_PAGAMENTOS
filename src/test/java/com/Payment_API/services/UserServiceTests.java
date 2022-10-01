package com.Payment_API.services;

import com.Payment_API.config.GenerateUUID;
import com.Payment_API.entities.account.Account;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.mapper.UserBankMapper;
import com.Payment_API.repositories.AccountRepository;
import com.Payment_API.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
public class UserServiceTests {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;


    @Test
    public void getUserById() {
        UUID id = GenerateUUID.generateUuid();
        UserBank userBank = new UserBank(id,"321654987","14122171059","douglas-mad@live.com","24");
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(userBank));
        UserBank userBankResult = userService.getUserById(id);
        Assertions.assertEquals(userBankResult.getIdade() , "24");
        Assertions.assertEquals(userBankResult.getEmail() , "douglas-mad@live.com");
    }

    @Test
    public void deleteUser(){
        UUID id = GenerateUUID.generateUuid();
        UserBank userBank = new UserBank(id,"321654987","14122171059","douglas-mad@live.com","24");
        Account account = new Account(0.0,userBank.getId());
        Mockito.when(userRepository.save(userBank)).thenReturn(userBank);
        Mockito.when(userService.saveUser(UserBankMapper.toDTO(userBank))).thenReturn(userBank);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(userBank));
        userService.saveUser(UserBankMapper.toDTO(userBank));
        UserBank userBank1 = userService.getUserById(userBank.getId());
        userService.deleteUser(id);
        userBank1 = userService.getUserById(userBank.getId());
        System.out.println(userBank1);
        Assertions.assertEquals(userBank1,Optional.empty());
    }


}
