package com.toolsChangelle.Dtos;

import com.toolsChangelle.entities.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	private UUID id;
	private Double currentBalance;
	private String name;
}
