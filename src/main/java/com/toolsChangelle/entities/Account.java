package com.toolsChangelle.entities;

import javax.persistence.*;

import com.toolsChangelle.config.GenerateUUID;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid")
    private UUID id;
    private Double balance;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserBank user;
    private UUID userID;

    public Account(Double balance, UUID userID) {
        this.id = GenerateUUID.generateUuid();
        this.userID = userID;
        this.balance = balance;
    }

}
