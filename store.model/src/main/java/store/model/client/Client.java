package store.model.client;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import store.model.common.Address;


@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ClientId;
	private String Name;
	private String cpf;
	private Calendar birthDate;
	
	@OneToMany(mappedBy = "addressId", targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> address;
	

	//Getters and Setters
	public int getId() {
		return ClientId;
	}


	public void setId(int ClientId) {
		this.ClientId = ClientId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Calendar getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}


//	public Address getAddress() {
//		return address;
//	}
//
//
//	public void setAddress(Address address) {
//		if(address.isValid())
//			this.address = address;
//	}
	
}
