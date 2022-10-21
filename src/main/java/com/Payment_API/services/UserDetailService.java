package com.Payment_API.services;

import com.Payment_API.entities.user.UserBank;
import com.Payment_API.jwt.data.UserDataDetails;
import com.Payment_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBank> userBank = userRepository.findByLogin(username);
        if(userBank.isPresent()){
            return new UserDataDetails(userBank);
        }
        throw new UsernameNotFoundException("User ["+ username + "] not found");
    }
}
