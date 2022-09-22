package com.toolsChangelle.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
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
}