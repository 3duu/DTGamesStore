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
		manager.persist(product);
	}

	public List<Product> list() {
		if(manager != null)
			return manager.createQuery("select distinct(p) from Product p", Product.class)
		.getResultList();
		else
			return null;
	}
	
	public Product getById(int productId) {
		if(manager != null)
			return manager.find(Product.class, productId);
		else
			return null;
	}
	
}
