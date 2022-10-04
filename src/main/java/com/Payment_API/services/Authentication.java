package com.Payment_API.services;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class Authentication {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public ResponseEntity<String> validatePassword(@RequestParam String login,
                                                   @RequestParam String password) {
        Optional<UserBank> userBank = userRepository.findByLogin(login);
        if (userBank.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in this database, try again with another login");
        }
        if (passwordEncoder.matches(userBank.get().getPassword(), password)) {
            return ResponseEntity.status(HttpStatus.OK).body("Welcome, you just logged in!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password is incorrect try again with another password");
    }

}
