package com.Payment_API.entities.user;

import com.Payment_API.config.GenerateUUID;
import com.Payment_API.entities.account.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

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
    public UserBank(String phoneNumber,String cpf,String email,String password){
        this.id = GenerateUUID.generateUuid();
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.cpf = cpf;
        this.email=email;
    }
    public UserBank(UUID id,String phoneNumber,String cpf,String email,String password){
        this.id = id;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.email=email;
    }


}