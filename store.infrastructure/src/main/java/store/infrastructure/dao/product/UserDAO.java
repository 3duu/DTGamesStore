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

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final String jpql = "SELECT u FROM User u WHERE u.userName = :login";
		List<User> users = null;
		try{
			users = manager.createQuery(jpql, User.class)
					.setParameter("login", username).getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		if(users == null || users.isEmpty()){
			throw new UsernameNotFoundException("O usuário " + username + " não existe");
		}
		
//		User u = new User();
//		u.setUserName("eduu.porto@gmail.com");
//		u.setPassword("nemesis164");
		
		return users.get(0);
	}
	
}
