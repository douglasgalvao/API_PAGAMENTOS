package com.Payment_API.repositories;

import com.Payment_API.entities.user.UserBank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;
import java.util.UUID;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    private UUID idExist;
    private UUID idNoExist;
    @BeforeEach
    void setUp() throws Exception{
        idExist = UUID.fromString("6fe825eb-c626-4b19-bac2-02dace9dff6c");
        idNoExist =UUID.fromString("2ba8135c-973d-403b-b3f8-9a28a9e0f427");
    }

    @Test
    public void shouldDeleteObjectWhenIdExists(){
        UUID userbank = idExist;
//        System.out.println(userbank);
        userRepository.deleteById(userbank);
        Optional<UserBank> result = userRepository.findById(userbank);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldThrowEmptyResultDataAccessExceptionIfNotExists(){
    Assertions.assertThrows(EmptyResultDataAccessException.class,()->{
        userRepository.deleteById(idNoExist);
    });
    }

    @Test
    public void shouldReturnUserbankIfIdExists(){
        Optional<UserBank> userBank = userRepository.findById(idExist);
        Assertions.assertTrue(userBank.isPresent());
    }

    @Test
    public void shouldReturnNullIfIdNoExists(){
        Optional<UserBank> userBank = userRepository.findById(idNoExist);
        Assertions.assertTrue(userBank.isEmpty());
    }


}
