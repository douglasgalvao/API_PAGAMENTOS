package com.Payment_API.controller;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.config.DecodeJWT;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.jwt.data.UserDataDetails;
import com.Payment_API.mapper.UserBankMapper;
import com.Payment_API.services.AccountService;
import com.Payment_API.services.UserService;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    //
    @Autowired
    private UserService userService;

    private AccountService accountService;
    private DecodeJWT decodeJWT;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UserBankDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<UserBankDTO> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(UserBankMapper.toDTO(UserBankMapper.toModel(userService.getUserById(id))));
    }

    @GetMapping(value = "/search/{login}")
    @ResponseBody
    public ResponseEntity<UserBankDTO> getUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok(UserBankMapper.toDTO(UserBankMapper.toModel(userService.getUserByLogin(login))));
    }

    @GetMapping(value = "/profile")
    @ResponseBody
    public ResponseEntity<DecodeJWT> getUserProfile(HttpServletRequest request) throws UnsupportedEncodingException {
        String token = request.getHeader("Authorization").split(" ")[1];
        return ResponseEntity.ok(DecodeJWT.getDecoded(token));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.deleteUser(id);
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<UserBankDTO> saveUser(@RequestBody UserBankDTO user) {
        return ResponseEntity.ok(UserBankMapper.toDTO(UserBankMapper.toModel(userService.saveUser(user))));
    }
}
