package com.toolsChangelle.entities;

public class Account {
	private Double balance;
	private Transaction[] transactions;
	private Long userId;

	public Account() {};

	public Account(Double balance, Long userId) {
		super();
		this.balance = balance;
		this.userId = userId;
	}

	public Double getBalance() {
		return balance;
	}

	public Long getUserId() {
		return userId;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
