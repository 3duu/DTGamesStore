package store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	protected final String searchPage = "products/productSearch";

	@ResponseBody
	@RequestMapping(value = "/mostsold", method = RequestMethod.GET)
	public List<Product> mostSold(HttpServletRequest request ) {

		if (productDAO != null) {
			// mais vendidos
			final List<Product> products = productDAO.list();
			for(Product p : products)
				p.setPriceValue(p.getPriceValue());
			return products;

		}
		return null;
	}
	
	//@SuppressWarnings("restriction")
	@RequestMapping("/{pageID}")
	public ViewModel getProductPage(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String code, HttpServletRequest request ) {
		
		ViewModel mv = null;
		
		if("show".equals(id)){
			
			if(!code.isEmpty()){
				mv = new ViewModel(shoopingPage, request);
				mv.addObject("productId", code);
				/*final int productId = Integer.parseInt(code);
				final Product p = productDAO.getById(productId);
				if(p != null){
					mv.addObject("productId", p.getProductId());
					//mv.addObject("productImage", new sun.misc.BASE64Encoder().encode(p.getProductImage()) );
				}*/
			}
			
		} else if("search".equals(id)){
			
			if(!code.isEmpty()){
				mv = new ViewModel(searchPage, request);
				mv.addObject("word", code);
				/*final List<Product> products = productDAO.getSearchResult(code);
				if(code != null){
					mv.addObject("productId", products);
					//mv.addObject("productImage", new sun.misc.BASE64Encoder().encode(p.getProductImage()) );
				}*/
			}
			
		}
		
		
		
		
		return mv;
	}
		
	
	@RequestMapping("/pget/{pageID}")
	public @ResponseBody Object getProduct( @PathVariable(value="pageID") String id, 
	                                 @RequestParam String product, HttpServletRequest request ) {
		
		if("p".equals(id)){
			int productId = 0; 
			try{
				productId = Integer.parseInt(product);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			final Product p = productDAO.getById(productId);
			if(p != null){
				p.setUrl("");
				p.setPriceValue(p.getPriceValue());
				return p;
			}
		}
		else if("s".equals(id)){
			final List<Product> products = productDAO.getSearchResult(product);
			return products;
		}
		
		if(!product.isEmpty()){
					
		}
		
		return null;
	}
	
	//Consoles
	@RequestMapping("/category/{pageID}")
	public ViewModel getProductsByType(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String type, HttpServletRequest request ) {
		
//		tipo.setValue(Integer);
		if(!"p".equals(id)){
			return null;
		}
		
		ViewModel mv = new ViewModel(shoopingPage, request);
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
	/*@RequestMapping(value="/search", method=RequestMethod.GET)
	public ViewModelModel searchProduct(@PathVariable(value="pageID") String id, 
	                                 @RequestParam String word, HttpServletRequest request ) {
		
		if(!"p".equals(id)){
			return null;
		}
		
		final ViewModelModel mv = new ViewModel(searchPage);
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
	}*/
	

}
