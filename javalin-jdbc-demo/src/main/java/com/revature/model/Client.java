package com.revature.model;

import java.util.ArrayList;
import java.util.Objects;

public class Client {

	private String firstName;
	private String lastName;
	private int index_id;
	
	
	// No-args constructor
	public Client() {
		super();
	}
	
	// Parameterized constructor
	public Client (int index_id,String firstname,String lastname) {
		super();
		this.index_id = index_id;
		this.firstName = firstname;
		this.lastName =lastname;
	}

	// Getters/Setters
	

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIndex_Id() {
		return index_id;
	}

	public void setIndexId(int index_id) {
		this.index_id = index_id;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(index_id, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return index_id == other.index_id && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", index_id=" + index_id + "]";
	}

	public void add(Client client) {
		// TODO Auto-generated method stub
		
	}

	public void deleteclient(Client client1) {
		// TODO Auto-generated method stub
		
	}

	public void clientacc_balance(Client client) {
		// TODO Auto-generated method stub
		
	}

	public void setClient(ArrayList arrayList) {
		// TODO Auto-generated method stub
		
	}

	// toString

	}
	

