package com.toolsChangelle.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.toolsChangelle.enums.StatusDescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionTransaction {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    private LocalDateTime dataHora = LocalDateTime.now();
    private String estabelecimento;
    private String codigoAutorizacao;
    @OneToOne(cascade = CascadeType.ALL)
    private BalanceDescription balance;
    private String nsu;
    private StatusDescription status;
    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;
}
