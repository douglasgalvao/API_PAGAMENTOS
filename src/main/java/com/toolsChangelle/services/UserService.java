package com.toolsChangelle.services;

import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.entities.UserBank;
import com.toolsChangelle.mapper.UserBankMapper;
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
                .map(UserBankMapper::toDTO)
                .collect(Collectors.toList());
    }


    public UserBank saveUser(UserBankDTO user) {
        UserBank userModel = UserBankMapper.toModel(user);
        userRepository.save(userModel);
        return userModel;
    }
}