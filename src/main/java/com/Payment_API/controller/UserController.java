package com.Payment_API.controller;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.mapper.UserBankMapper;
import com.Payment_API.services.AccountService;
import com.Payment_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<UserBankDTO> getUserById(@PathVariable UUID id){
        return ResponseEntity.ok(UserBankMapper.toDTO(userService.getUserById(id)));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable UUID id){
        userService.deleteUser(id);
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<UserBankDTO> saveUser(@RequestBody UserBankDTO user){
        return ResponseEntity.ok(UserBankMapper.toDTO(userService.saveUser(user)));
    }
}
