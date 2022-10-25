package com.Payment_API.entities.transaction;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.Payment_API.enums.StatusDescription;

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
    @OneToOne(cascade = CascadeType.ALL)
    private BalanceDescription balance;
    private StatusDescription status;
    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;
}
