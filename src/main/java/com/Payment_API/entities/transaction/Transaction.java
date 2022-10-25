package com.Payment_API.entities.transaction;

import javax.persistence.*;

import com.Payment_API.entities.transaction.DescriptionTransaction;
import com.Payment_API.entities.transaction.PaymentMethodTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "uuid")
	private UUID id;
	@OneToOne(cascade = CascadeType.ALL)
	private DescriptionTransaction description;
	private Double balance;
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentMethodTransaction paymentMethod;
	@Column(unique = true)
	private UUID accountID;


}
