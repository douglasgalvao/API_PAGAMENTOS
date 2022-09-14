package com.toolsChangelle.Dtos;

import javax.persistence.OneToOne;

import com.toolsChangelle.entities.DescriptionTransaction;
import com.toolsChangelle.entities.PaymentMethodTransaction;

public class TransactionDTO {
	private String cartao;
	@OneToOne
	private DescriptionTransaction description;
	@OneToOne
	private PaymentMethodTransaction paymentMethod;
	
	public TransactionDTO() {
	};

	public TransactionDTO(String cartao, DescriptionTransaction description, PaymentMethodTransaction paymentMethod) {
		this.cartao = cartao;
		this.description = description;
		this.paymentMethod = paymentMethod;
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
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodTransaction paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Transaction [cartao=" + cartao + ", description=" + description + ", paymentMethod="
				+ paymentMethod + "]";
	}
}
