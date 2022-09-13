package com.toolsChangelle.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartao;
	@OneToOne(cascade = CascadeType.ALL)
	private Description description;
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentMethod formaPagamento;
	
	public Transaction() {
	};

	public Transaction(String cartao, Description description, PaymentMethod formaPagamento) {
		this.cartao = cartao;
		this.description = description;
		this.formaPagamento = formaPagamento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public PaymentMethod getPaymentMethod() {
		return formaPagamento;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.formaPagamento = paymentMethod;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", cartao=" + cartao + ", description=" + description + ", paymentMethod="
				+ formaPagamento + "]";
	}

	
}
