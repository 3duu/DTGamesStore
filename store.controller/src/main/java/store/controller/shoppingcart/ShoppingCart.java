package store.controller.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import store.model.product.Product;
import store.model.user.User;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8145848924990101545L;
	
	public User client;
	private List<Product> products;
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
		
		this.products.add(product);
		this.count = products.size();
	}

	public int getCount() {
		if(products != null)
			this.count = products.size();
		return count;
	}
	
	

}
