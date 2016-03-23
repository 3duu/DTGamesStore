package store.infrastructure.dao.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import store.model.product.Product;

@Repository
public class ProductDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Product product){
		try{
			manager.persist(product);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Product> listAll() {
		try{
			if(manager != null)
				return manager.createQuery("SELECT distinct(p) FROM Product p", Product.class)
			.getResultList();
			else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Product getById(int productId) {
		try{
			if(manager != null)
				return manager.find(Product.class, productId);
			else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Product> getSearchResult(String word) {
		
		final String statement = "SELECT p FROM Product p WHERE p.name LIKE :word OR p.tags LIKE :word";
		
		try{
			if(manager != null)
				return manager.createQuery(statement, Product.class)
						.setParameter("word", "%" + word + "%").getResultList();
			else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Product> listMostSold() {
		final String statement = "SELECT p FROM Product p ORDER BY p.sells desc";
		try{
			if(manager != null)
				return manager.createQuery(statement, Product.class)
			.getResultList();
			else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Product> listTop10MostSold() {
		final String statement = "SELECT TOP 10 * FROM Product p ORDER BY p.sells desc";
		try{
			if(manager != null) {
				@SuppressWarnings("unchecked")
				List<Product> resultList = (List<Product>)manager.createNativeQuery(statement, Product.class)
			.getResultList();
				return resultList;
			} else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
