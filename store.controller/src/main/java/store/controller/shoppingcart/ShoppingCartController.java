package store.controller.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import store.infrastructure.dao.product.ProductDAO;
import store.model.product.Product;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShoppingCart shoppingCart;
	
	@RequestMapping(method=RequestMethod.POST)
		public ModelAndView add(Integer productId){
		//ShoppingItem item = createItem(productId);
		//shoppingCart.add(item);
		return new ModelAndView("redirect:/produtos");
	}
	
//	private ShoppingItem createItem(Integer productId) {
//			Product product = productDAO.find(productId);
//			ShoppingItem item = new ShoppingItem(product);
//			return item;
//	}
}
