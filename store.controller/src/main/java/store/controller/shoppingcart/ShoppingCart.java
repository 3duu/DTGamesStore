package store.controller.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import store.model.product.Product;
import store.model.user.User;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
	/**
	 * 
	 */
	public User client;
	private List<Product> products;
	private Map<Integer, Integer> productCount;
	private int count;
	
	public ShoppingCart(){
		this.products = new ArrayList<Product>(); 
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void add(Product product){
		if(products == null)
			products = new ArrayList<Product>();
		
		if(productCount == null)
			productCount = new HashMap<Integer, Integer>();
		
		this.products.add(product);
		this.count = products.size();
		
		Integer pCount = productCount.get(product.getProductId());
		if(pCount == null)
			pCount = 1;
		else
			pCount++;
		
		productCount.put(product.getProductId(), pCount);
	}
	
	public void remove(Product product){
		if(products == null)
			products = new ArrayList<Product>();
		
		if(productCount == null)
			productCount = new HashMap<Integer, Integer>();
		
		this.products.remove(product);
		this.count = products.size();
		
		Integer pCount = productCount.get(product.getProductId());
		if(pCount == null)
			pCount = 1;
		else
			pCount--;
		
		productCount.put(product.getProductId(), pCount);
	}

	public int getCount() {
		if(products != null)
			this.count = products.size();
		return count;
	}

	public Map<Integer, Integer> getProductCount() {
		return productCount;
	}


}
