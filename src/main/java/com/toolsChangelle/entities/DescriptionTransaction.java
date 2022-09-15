package com.toolsChangelle.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	
	private String nsu;
	
	private StatusDescription status;
	@OneToOne
	private Transaction transaction;

}
