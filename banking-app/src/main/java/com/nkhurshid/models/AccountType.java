package com.nkhurshid.models;

public enum AccountType {
	
	CUR("Current Account"), SAV("Savings Account");
	
	private String name;
	
	private AccountType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
