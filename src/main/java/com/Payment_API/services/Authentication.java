package com.Payment_API.services;

import com.Payment_API.entities.user.UserBank;
import com.Payment_API.repositories.UserRepository;
import com.Payment_API.repositories.UserRepositoryByLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class Authentication {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserRepositoryByLogin userRepositoryByLogin;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public Authentication(UserRepository userRepository, UserRepositoryByLogin userRepositoryByLogin, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRepositoryByLogin = userRepositoryByLogin;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ResponseEntity<String> validatePassword(@RequestParam String login,
                                                   @RequestParam String password) {
        Optional<UserBank> userBank = userRepositoryByLogin.findByLogin(login);
        if (userBank.isPresent()) {
            if (passwordEncoder.matches(userBank.get().getPassword(), password)) {
                return ResponseEntity.status(HttpStatus.OK).body("Welcome, you just logged in!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in this database, try again with another login");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password is incorrect try again with another password");
    }

}
