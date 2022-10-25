package com.Payment_API.entities.user;

import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.config.GenerateUUID;
import com.Payment_API.entities.account.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBank {

    @GeneratedValue(generator = "uuid2",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid")
    @Id
    private UUID id;
    private String phoneNumber;

    @CPF
    private String cpf;
    @Column(unique = true)
    private String login;
    private String password;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private UUID accountID;
    public UserBank(String phoneNumber,String cpf,String email,String password,String login,UUID accountID){
        this.id = GenerateUUID.generateUuid();
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.cpf = cpf;
        this.accountID = accountID;
        this.login = login;
        this.email=email;
    }
    public UserBank(UUID id,String phoneNumber,String cpf,String email,String password,UUID accountID){
        this.id = id;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.accountID = accountID;
        this.email=email;
    }

    public String toStringDTO(){
        UserBank userBank1 = UserBank.builder()
                .login(this.getLogin())
                .phoneNumber(this.phoneNumber)
                .password(this.password)
                .email(this.email)
                .id(this.id)
                .accountID(this.accountID)
                .build();
        return userBank1.toString();
    }

    public void toUpperCaseName(){
        this.email = email.toUpperCase();
        System.out.println(this.email);
    }


}