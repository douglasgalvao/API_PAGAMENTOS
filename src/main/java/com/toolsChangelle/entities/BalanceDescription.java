package com.toolsChangelle.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String balanceAntesDaTransacao;
    private String balanceDepoisDaTransacao;
    @OneToOne(cascade = CascadeType.ALL)
    private DescriptionTransaction transaction;
}
