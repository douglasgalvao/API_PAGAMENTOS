package com.toolsChangelle.services;

import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.UserBank;
import com.toolsChangelle.mapper.UserBankMapper;
import com.toolsChangelle.repositories.AccountRepository;
import com.toolsChangelle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Transactional
    public List<UserBankDTO> getAllUsers() {
        List<UserBank> accounts = userRepository.findAll();
        return accounts.stream()
                .map(UserBankMapper::toDTO)
                .collect(Collectors.toList());
    }


    public UserBank saveUser(UserBankDTO user) {
        UserBank userBank = userRepository.save(UserBankMapper.toModel(user));
       Account newAccount = accountRepository.save(new Account(0.0,userBank.getId()));
        userBank.setAccount(newAccount);
        userBank.setAccountID(newAccount.getId());
        return userRepository.save(userBank);
    }
}