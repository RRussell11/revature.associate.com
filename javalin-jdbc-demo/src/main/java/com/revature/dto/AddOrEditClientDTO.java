package com.revature.dto;

import java.util.Objects;

public class AddOrEditClientDTO {

	private String firstName;
	private String lastName;
	
	//private int indexid;

  /* public int getIndexid() {
		return indexid;
	}

	public void setIndexid(int indexid) {
		this.indexid = indexid;*/
	
	

	public AddOrEditClientDTO() {
		super();
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	

	@Override
	public String toString() {
		return "AddOrEditClientDTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		AddOrEditClientDTO other = (AddOrEditClientDTO) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	public AddOrEditClientDTO editclient(AddOrEditClientDTO clientname) {
		return clientname;
		
	}

	public void setIndexid(int i) {
		return; 
		
	}

	

}

	
	