package com.toolsChangelle.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.toolsChangelle.enums.Tipo;
@Entity
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String parcelas;
	private Tipo tipo;
	@OneToOne
	private Transaction transaction;
	public PaymentMethod() {
	}
	public PaymentMethod(String parcelas, Tipo tipo) {
		super();
		this.parcelas = parcelas;
		this.tipo = tipo;
	}
	public String getParcelas() {
		return parcelas;
	}
	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	};
	
}
