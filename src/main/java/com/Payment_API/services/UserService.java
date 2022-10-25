package com.Payment_API.services;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.account.Account;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.mapper.UserBankMapper;
import com.Payment_API.repositories.AccountRepository;
import com.Payment_API.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Authentication authentication;
    @Autowired
    private AccountRepository accountRepository;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Transactional
    public List<UserBankDTO> getAllUsers() {
        List<UserBank> accounts = userRepository.findAll();
        return accounts.stream()
                .map(UserBankMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserBankDTO getUserByLogin(String login){
        UserBankDTO userBankDTO = UserBankMapper.toDTO(userRepository.findByLogin(login).orElseThrow(()-> new EntityNotFoundException("Not Found in database by login")));
        System.out.println(userBankDTO);
        return userBankDTO;
    }
    @Transactional
    public UserBankDTO getUserById(UUID id) {
        return UserBankMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found in database by id")));
    }

    @Transactional
    public void deleteUser(UUID id) {
        Optional<UserBank> userBank = userRepository.findById(id);
        if(userBank.isPresent()){
            userRepository.deleteById(id);
        }
        throw new EntityNotFoundException("User not found to delete");
    }

    @Transactional
    public UserBankDTO saveUser(UserBankDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        UserBank userBank = userRepository.save(UserBankMapper.toModel(user));
        Account newAccount = accountRepository.save(new Account(0.0, userBank.getId()));
        userBank.setAccount(newAccount);
        userBank.setAccountID(newAccount.getId());
        userBank.setEmail(user.getEmail());
        return UserBankMapper.toDTO(userRepository.save(userBank));
    }
}