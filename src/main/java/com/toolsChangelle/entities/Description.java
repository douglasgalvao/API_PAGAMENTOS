package com.toolsChangelle.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

enum Status {
	AUTORIZADO, NEGADO
};

@Entity
public class Description {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String valor;
	private LocalDateTime dataHora = LocalDateTime.now();
	private String estabelecimento;
	private String codigoAutorizacao;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nsu;
	private Status status;
	
	@OneToOne
	private Transaction transaction;

	public Description() {
	}

	public Description(String valor, String estabelecimento, LocalDateTime dataHora, String nsu, Status status) {
		super();
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.dataHora = dataHora;
		this.status = status;
	}

	public String getValor() {
		return valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.codigoAutorizacao = authorizationCode;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDataHora() {
		DateTimeFormatter brFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		return this.dataHora.format(brFormat);
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public String getAuthorizationCode() {
		return codigoAutorizacao;
	}

	public String getNsu() {
		return nsu;
	}

	public Status getStatus() {
		return status;
	}

}
