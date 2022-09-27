package com.toolsChangelle.entities;

import javax.persistence.*;

import com.toolsChangelle.Dtos.TransactionDTO;

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
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentMethodTransaction paymentMethod;
	private UUID accountID;

}
