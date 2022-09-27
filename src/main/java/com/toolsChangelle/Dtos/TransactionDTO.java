package com.toolsChangelle.Dtos;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.toolsChangelle.entities.Account;
import com.toolsChangelle.entities.DescriptionTransaction;
import com.toolsChangelle.entities.PaymentMethodTransaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TransactionDTO {
	private UUID id;
	private UUID accountID;
	private DescriptionTransaction description;
	private PaymentMethodTransaction paymentMethod;
}
