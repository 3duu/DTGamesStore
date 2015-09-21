package store.controller.shoppingcart;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import store.model.product.Product;
import store.model.user.User;

@Component
//@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class ShoppingCart {
	public User client;
	public List<Product> products;
	
	public void  Add(Product product){
		this.products.add(product);
	}
}
