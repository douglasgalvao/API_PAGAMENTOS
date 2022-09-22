package com.toolsChangelle.controller;

import com.toolsChangelle.Dtos.UserBankDTO;
import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.UserBank;
import com.toolsChangelle.mapper.AccountMapper;
import com.toolsChangelle.mapper.UserBankMapper;
import com.toolsChangelle.services.AccountService;
import com.toolsChangelle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {
//
    @Autowired
    private UserService userService;
    private AccountService accountService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UserBankDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserBankDTO> saveUser(@RequestBody UserBankDTO user){
        return ResponseEntity.ok(UserBankMapper.toDTO(userService.saveUser(user)));
    }
}
