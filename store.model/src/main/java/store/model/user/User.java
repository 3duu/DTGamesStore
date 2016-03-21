package store.model.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import store.model.common.Address;


//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name="[User]")
@Table(name="[User]")
public class User implements UserDetails{
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3783444837711144238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length=50, columnDefinition="varchar(50)")
	private String name;
	
	@Column(name="userName", length=50, columnDefinition="varchar(50)")
	private String userName;

	@Column(length=50, columnDefinition="varchar(50)")
	private String password;
	
	@Column(length=11, columnDefinition="varchar(11)")
	private String cpf;
	
	@Column(columnDefinition="DateTime")
	private Calendar birthDate;
	
	@JoinColumn(name="addressId")
	@ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	@JoinColumn(name="orderId")
	@ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> orders;
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();

	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
