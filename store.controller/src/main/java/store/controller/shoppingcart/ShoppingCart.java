package store.controller.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import store.model.product.Product;
import store.model.user.User;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class ShoppingCart {
	public User client;
	public List<Product> products;
	private int count = 0;
	
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
