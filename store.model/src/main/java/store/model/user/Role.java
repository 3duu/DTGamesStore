package store.model.user;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="Roles")
public class Role implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 190116184369267866L;
	@Id
	private String name;
	
	
	@ManyToMany
	@JoinTable(name = "RolesByUser", 
			   joinColumns = @JoinColumn(name = "roleName"), 
			   inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<User> users = new ArrayList<User>();
	
	
//	@JoinColumn(name="userId")
//	@ManyToMany(targetEntity = User.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<User> users;
	
	public String getAuthority() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
