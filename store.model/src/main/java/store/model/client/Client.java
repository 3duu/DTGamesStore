package store.model.client;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import store.model.common.Address;


@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	private String name;
	private String cpf;
	private Calendar birthDate;
	
	@JoinColumn(name="addressId")
	@ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> address;
	

	//Getters and Setters
	public int getId() {
		return clientId;
	}


	public void setId(int clientId) {
		this.clientId = clientId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
