package com.Payment_API.services;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.Account;
import com.Payment_API.entities.UserBank;
import com.Payment_API.mapper.UserBankMapper;
import com.Payment_API.repositories.AccountRepository;
import com.Payment_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
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

    @Transactional
    public UserBank getUserById(UUID id){
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Not found"));
    }


    @Transactional
    public UserBank saveUser(UserBankDTO user) {
        UserBank userBank = userRepository.save(UserBankMapper.toModel(user));
       Account newAccount = accountRepository.save(new Account(0.0,userBank.getId()));
        userBank.setAccount(newAccount);
        userBank.setAccountID(newAccount.getId());
        return userRepository.save(userBank);
    }
}