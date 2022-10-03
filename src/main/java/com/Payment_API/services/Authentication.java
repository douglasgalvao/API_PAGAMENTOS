package com.Payment_API.services;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class Authentication {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public ResponseEntity<UserBank> validatePassword(@RequestParam String login,
                                                 @RequestParam String password){
        Optional<UserBank> userBank = userRepository.findByLogin(login);
        if(userBank.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("there's no user with this login in this database");
        }
    }

}
