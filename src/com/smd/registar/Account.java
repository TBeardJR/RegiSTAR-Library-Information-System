package com.smd.registar;

public class Account {
	private boolean isMembershipActive;
	private boolean isAdministrator;
	private String name;
	private String address;
	private String paymentInfo;
	private String password;
	private double balance;
	
	public boolean getIsMembershipActive() {
		return isMembershipActive;
	}

	public void setIsMembershipActive(boolean isMembershipActive) {
		this.isMembershipActive = isMembershipActive;
	}

	public boolean getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String userName) {
		name = userName;		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String userAddress) {
		address = userAddress;		
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String userInfo) {
		paymentInfo = userInfo;		
	}

	public void deleteAccount() {
		paymentInfo = "";
		setIsMembershipActive(false);		
	}

	public void cancelMembership() {
		setIsMembershipActive(false);		
	}	

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
