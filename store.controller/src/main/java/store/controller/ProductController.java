package store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import store.infrastructure.dao.product.ProductDAO;
//import store.infrastructure.utils.Int32;
import store.model.product.Product;

//@Transactional
@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	protected final String shoopingPage = "products/productBuy";
	protected final String consolesPage = "products/consoles";

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
	@RequestMapping("/{pageID}")
	public ModelAndView getProductPage(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String code) {
		
		if(!"p".equals(id)){
			return null;
		}
		
		ModelAndView mv = new ModelAndView(shoopingPage);
		if(!code.isEmpty()){
			final int productId = Integer.parseInt(code);
			final Product p = productDAO.getById(productId);
			if(p != null){
				mv.addObject("productId", p.getProductId());
				//mv.addObject("productImage", new sun.misc.BASE64Encoder().encode(p.getProductImage()) );
			}
				
		}
		
		return mv;
	}
		
	
	@RequestMapping("/pget/{pageID}")
	public @ResponseBody Product getProduct(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String product) {
		
		if(!"p".equals(id)){
			return null;
		}
		
		if(!product.isEmpty()){
			
			int productId = Integer.parseInt(product);
			Product p = productDAO.getById(productId);
			if(p != null){
				p.setUrl("");
				p.setPriceValue(p.getPriceValue());
				return p;
			}
				
		}
		
		return null;
	}
	
	//Consoles
	@RequestMapping("/category/{pageID}")
	public ModelAndView getProductsByType(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String type) {
		
//		tipo.setValue(Integer);
		if(!"p".equals(id)){
			return null;
		}
		
		ModelAndView mv = new ModelAndView(shoopingPage);
		if(!type.isEmpty()){
			final int productId = Integer.parseInt(type);
			final Product p = productDAO.getById(productId);
			if(p != null){
				p.setPriceValue(p.getPriceValue());
				mv.addObject("productId", p.getProductId());
				//mv.addObject("productImage", new sun.misc.BASE64Encoder().encode(p.getProductImage()) );
			}
				
		}
		
		return mv;
	}
	
	//Busca
	@RequestMapping("/search/{pageID}")
	public ModelAndView getSearchPage(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String word) {
		
		
		if(!"p".equals(id)){
			return null;
		}
		
		ModelAndView mv = new ModelAndView(shoopingPage);
		if(!word.isEmpty()){
			final int productId = Integer.parseInt(word);
			final Product p = productDAO.getById(productId);
			if(p != null){
				p.setPriceValue(p.getPriceValue());
				mv.addObject("productId", p.getProductId());
				//mv.addObject("productImage", new sun.misc.BASE64Encoder().encode(p.getProductImage()) );
			}
				
		}
		
		return mv;
	}

}
