package com.revature.model;

import java.util.List;

public class Account {
	
	private int checking_account;
	private int saving_account;
	private double clientacc_balance;
	private int bankLite;
	private int bankJL;
	
	
	public Account(int i, String string) {
		 super();
	}
		// Parameterized constructor
			public Account( int checking_account, int saving_account, int acc_balance, int id,  int bankLite, int bankJL) {
				super();
				this.checking_account=checking_account;
				this.saving_account = saving_account;
				this.clientacc_balance= acc_balance;
				this.setBankLite(1);
				this.setBankJL(2);
			}

		
	
	public int getChecking_account() {
		return checking_account;
	}
	public void setCheckingaccount(int checking_account) {
		this.checking_account = checking_account;
	}
	public int getSavingaccount() {
		return saving_account;
	}
	public void setSavingaccount(int saving_account) {
		this.saving_account = saving_account;
	}
	public double getBalance() {
		return clientacc_balance;
	}
	public void setBalance(double balance) {
		this.clientacc_balance = balance;
	}
	public static String getId(int id) {
	return null;
	}
	public static void setClient(List<Client> clients) {
		// TODO Auto-generated method stub
		
	}
	public int getBankLite() {
		return bankLite;
	}
	public void setBankLite(int bankLite) {
		this.bankLite = bankLite;
	}
	public int getBankJL() {
		return bankJL;
	}
	public void setBankJL(int bankJL) {
		this.bankJL = bankJL;
	}
	

}
