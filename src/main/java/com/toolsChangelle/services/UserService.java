package com.toolsChangelle.services;

import com.toolsChangelle.Dtos.AccountDTO;
import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.UserBank;
import com.toolsChangelle.mapper.AccountMapper;
import com.toolsChangelle.repositories.AccountRepository;
import com.toolsChangelle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserBankDTO> getAllUsers() {
        List<UserBank> accounts = userRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }
}