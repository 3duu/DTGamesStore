package store.infrastructure.dao.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import store.model.user.User;

@Repository
public class UserDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;
	
	public void save(User user){
		try{
			manager.persist(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		String jpql = "select u from User u where u.login = :login";
		List<User> users = manager.createQuery(jpql,User.class)
				.setParameter("login", "eduardo").getResultList();

		if(users.isEmpty()){
			throw new UsernameNotFoundException("O usuário "+"eduardo"+" não existe");
		}
		return users.get(0);
	}
	
}
