package com.toolsChangelle.entities;

import com.toolsChangelle.config.GenerateUUID;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid",name = "account_id")
    private UUID id;
    @Column(name = "account_balance")
    private Double balance;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserBank user;
    @Column(name = "user_id")
    private UUID userID;

    public Account(Double balance,UUID userID){
        this.id = GenerateUUID.generateUuid();
        this.userID=userID;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
