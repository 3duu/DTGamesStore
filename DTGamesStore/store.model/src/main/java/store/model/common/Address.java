package store.model.common;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import store.model.interfaces.Model;


@Entity
public class Address implements Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(columnDefinition="varchar(50)")
	private String street;
	
	@Column(columnDefinition="varchar(50)")
	private String district;
	
	@Column(columnDefinition="varchar(10)")
	private String number;
	
	@Column(l,columnDefinition="varchar(100)")
	private String City;
	
	@Column(columnDefinition="char(2)")
	private String UF;
	
	//Getters and Setters
	public int getaddressId() {
		return addressId;
	}


	public void setaddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getUF() {
		return UF;
	}


	public void setUF(String uF) {
		UF = uF;
	}
	
	public boolean isValid(){
		return true;
	}


	public Address create() {
		Address end = new Address();
		//end.setaddressId(UUID.randomUUID());
		return end;
	}

}
