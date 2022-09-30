package com.Payment_API.entities;

import com.Payment_API.config.GenerateUUID;
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
    @Id
    @GeneratedValue(generator = "uuid2",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String phoneNumber;

    @CPF
    private String cpf;
    private String email;
    private String idade;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private UUID accountID;
    public UserBank(String phoneNumber,String cpf,String email,String idade){
        this.id = GenerateUUID.generateUuid();
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.email=email;
        this.idade=idade;
    }


}