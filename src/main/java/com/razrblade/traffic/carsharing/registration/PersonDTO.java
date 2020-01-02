package com.razrblade.traffic.carsharing.registration;

import com.razrblade.traffic.carsharing.model.HomoMobilis;

import lombok.Data;

@Data
public class PersonDTO {

	private String firstName;

	private String lastName;

	private String email;

	private String office;

	private String phone;

	public PersonDTO() {
		super();
	}

	public PersonDTO(HomoMobilis mh) {
		this.firstName = mh.getFirstName();
		this.lastName = mh.getLastName();
		this.email = mh.getEmail();
		this.office = mh.getOffice();
		this.phone = mh.getPhone();

	}
}
