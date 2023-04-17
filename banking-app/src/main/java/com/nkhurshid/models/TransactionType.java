package com.nkhurshid.models;

public enum TransactionType {
	
	DEPOSIT("Deposit"), WITHDRAW("Withdraw"), OPENING_BALANCE("Opening Balance"), REVERSAL("Reversal"), TRANSFER("Transfer");
	
	private String name;
	
	private TransactionType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
