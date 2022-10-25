package com.Payment_API.services;

import com.Payment_API.entities.user.UserBank;
import com.Payment_API.jwt.data.UserDataDetails;
import com.Payment_API.repositories.UserRepository;
import com.Payment_API.repositories.UserRepositoryByLogin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRepositoryByLogin userRepositoryByLogin;

    public UserDetailService(UserRepository userRepository, UserRepositoryByLogin userRepositoryByLogin) {
        this.userRepository = userRepository;
        this.userRepositoryByLogin = userRepositoryByLogin;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBank> userBank = userRepositoryByLogin.findByLogin(username);
        if(userBank.isPresent()){
            return new UserDataDetails(userBank);
        }
        throw new UsernameNotFoundException("User ["+ username + "] not found");
    }
}
