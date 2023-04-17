package com.nkhurshid.models;

public class LoginForm {
	
	private String phoneNo;
	private String password;
	private long accountNo;
	private double withdrawAmount;
	
	public LoginForm() {}
	
	public LoginForm(String phoneNo, String password, long accountNo) {
		super();
		this.phoneNo = phoneNo;
		this.password = password;
		this.accountNo = accountNo;
	}
	
	public LoginForm(String phoneNo, String password, long accountNo, double withdrawAmount) {
		super();
		this.phoneNo = phoneNo;
		this.password = password;
		this.accountNo = accountNo;
		this.withdrawAmount = withdrawAmount;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
}
