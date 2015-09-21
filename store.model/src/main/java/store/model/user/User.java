package store.model.user;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import store.model.common.Address;


@Entity(name="[User]")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length=50, columnDefinition="varchar(50)")
	private String name;
	
	@Column(length=11, columnDefinition="varchar(11)")
	private String cpf;
	
	@Column(columnDefinition="DateTime")
	private Calendar birthDate;
	
	@JoinColumn(name="addressId")
	@ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> addresses;

	
	//Getters and Setters
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	
	
}
