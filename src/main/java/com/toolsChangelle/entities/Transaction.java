package com.toolsChangelle.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.toolsChangelle.Dtos.TransactionDTO;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartao;
	@OneToOne(cascade = CascadeType.ALL)
	private DescriptionTransaction description;
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentMethodTransaction formaPagamento;

	public Transaction() {
	};

	public Transaction(TransactionDTO transaction) {
		this.cartao = transaction.getCartao();
		this.description = transaction.getDescription();
		this.formaPagamento = transaction.getPaymentMethod();
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

	public DescriptionTransaction getDescription() {
		return description;
	}

	public void setDescription(DescriptionTransaction description) {
		this.description = description;
	}

	public PaymentMethodTransaction getPaymentMethod() {
		return formaPagamento;
	}

	public void setPaymentMethod(PaymentMethodTransaction paymentMethod) {
		this.formaPagamento = paymentMethod;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", cartao=" + cartao + ", description=" + description + ", paymentMethod="
				+ formaPagamento + "]";
	}

}
