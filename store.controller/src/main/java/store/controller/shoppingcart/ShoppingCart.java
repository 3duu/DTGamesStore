package store.controller.shoppingcart;

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
public class ShoppingCart {
	public User client;
	public List<Product> products;
	private int count;
	
	public ShoppingCart(){
		this.products = new ArrayList<Product>(); 
	}
	
	public void  Add(Product product){
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
