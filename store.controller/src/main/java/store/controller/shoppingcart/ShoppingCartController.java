package store.controller.shoppingcart;

import javax.servlet.http.HttpServletRequest;

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;*/

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import store.controller.ViewModel;
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
	
//	@Autowired
//	private HttpSession session;
	
	protected final String shoppingCartPage = "cart/shoppingCartShow";
	
	@RequestMapping(value="/additem", method=RequestMethod.POST)
		public @ResponseBody int add( @RequestBody Product product, HttpServletRequest request ){
		if(product != null && product.getProductId() != 0){
			Product item = productDAO.getById(product.getProductId());
			shoppingCart.add(item);
		}
		
		return shoppingCart.getCount();
	}
	
	@RequestMapping(value="/removeitem", method=RequestMethod.POST)
	public @ResponseBody int remove( @RequestBody Product product, HttpServletRequest request){
	if(product != null && product.getProductId() != 0){
		Product item = productDAO.getById(product.getProductId());
		shoppingCart.remove(item);
	}
	
	return shoppingCart.getCount();
}
	
	@RequestMapping(value="/cartinfo", method=RequestMethod.GET)
	public @ResponseBody ShoppingCart getCart( @RequestParam String userId, HttpServletRequest request  ) {
		
		if(!userId.isEmpty() && shoppingCart != null){
			
			final ShoppingCart cart = new ShoppingCart();
			for(Product p : shoppingCart.getProducts()){
				p.setPriceValue(p.getPriceValue());
				cart.add(p);
			}
				
			
			return cart;
			
		}
		
		return null;
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public  ModelAndView showCart(HttpServletRequest request ) {
		ModelAndView mv = new ViewModel(shoppingCartPage, request);
		return mv;
	}
	

}
