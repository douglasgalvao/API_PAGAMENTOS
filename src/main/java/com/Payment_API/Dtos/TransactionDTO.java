package com.Payment_API.Dtos;

import com.Payment_API.entities.DescriptionTransaction;
import com.Payment_API.entities.PaymentMethodTransaction;

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
