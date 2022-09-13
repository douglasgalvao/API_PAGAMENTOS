package com.toolsChangelle.Dtos;

import javax.persistence.OneToOne;

import com.toolsChangelle.entities.Description;
import com.toolsChangelle.entities.PaymentMethod;

public class TransactionDTO {
	private String cartao;
	@OneToOne
	private Description description;
	@OneToOne
	private PaymentMethod paymentMethod;
	
	public TransactionDTO() {
	};

	public TransactionDTO(String cartao, Description description, PaymentMethod paymentMethod) {
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

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Transaction [cartao=" + cartao + ", description=" + description + ", paymentMethod="
				+ paymentMethod + "]";
	}
}
