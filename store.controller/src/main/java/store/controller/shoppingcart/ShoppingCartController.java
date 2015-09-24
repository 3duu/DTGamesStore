package store.controller.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import store.infrastructure.dao.product.ProductDAO;
import store.model.product.Product;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/shopping")
public class ShoppingCartController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShoppingCart shoppingCart;
	
	@RequestMapping(value="/additem", method=RequestMethod.POST)
		public @ResponseBody int add( @RequestBody Product product ){
		if(product != null && product.getProductId() != 0){
			Product item = productDAO.getById(product.getProductId());
			shoppingCart.add(item);
		}
		
		return shoppingCart.getCount();
	}
	
	@RequestMapping(value="/cartinfo", method=RequestMethod.GET)
	public @ResponseBody ShoppingCart getCart( @RequestParam String userId ) {
		
		if(!userId.isEmpty()){
			return new ShoppingCart();	
		}
		
		return null;
	}
	
//	private ShoppingItem createItem(Integer productId) {
//			Product product = productDAO.find(productId);
//			ShoppingItem item = new ShoppingItem(product);
//			return item;
//	}
}
