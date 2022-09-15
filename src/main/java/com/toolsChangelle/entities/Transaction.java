package com.toolsChangelle.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.toolsChangelle.Dtos.TransactionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartao;
	@ManyToOne(fetch = FetchType.EAGER, optional = true , cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
	@JoinColumn(name="accountId")
	private Account account;
	@OneToOne(cascade = CascadeType.ALL)
	private DescriptionTransaction description;
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentMethodTransaction paymentMethod;

}
