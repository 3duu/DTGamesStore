package store.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import store.infrastructure.dao.product.ProductDAO;
import store.model.product.Product;
import store.model.product.ProductType;
import store.model.product.TargetConsole;

@Transactional
@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	protected final String shoopingPage = "products/productBuy";

	@ResponseBody
	@RequestMapping(value = "/mostsold", method = RequestMethod.GET)
	public List<Product> mostSold() {

		if (productDAO != null) {
			// mais vendidos
			List<Product> products = productDAO.list();
			for(Product p : products)
				p.setDescription(p.getProductDescription());
			return products;

		}
		return null;
	}
	
	//@SuppressWarnings("restriction")
	@RequestMapping("/shopping/{pageID}")
	public ModelAndView getAttr(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String codigo) {
		
		if(!"p".equals(id)){
			return null;
		}
		
		ModelAndView mv = new ModelAndView(shoopingPage);
		if(!codigo.isEmpty()){
			final int productId = Integer.parseInt(codigo);
			final Product p = productDAO.getById(productId);
			if(p != null){
				mv.addObject("productId", p.getProductId());
				//mv.addObject("productImage", new sun.misc.BASE64Encoder().encode(p.getProductImage()) );
			}
				
		}
		
		return mv;
	}
		
	
	@RequestMapping("/shopping/pget/{pageID}")
	public @ResponseBody Product getProduct(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String product) {
		
		if(!"p".equals(id)){
			return null;
		}
		
		if(!product.isEmpty()){
			int productId = Integer.parseInt(product);
			Product p = productDAO.getById(productId);
			if(p != null)
				return p;
		}
		
		return null;
	}
	
	

}
