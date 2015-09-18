package store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import store.infrastructure.dao.product.ProductDAO;
import store.model.product.Product;

//@Transactional
@Controller
@RequestMapping("/products")
public class ProductController {
	
//	@Autowired
//	private HttpServletRequest context;
	
	//@Autowired
	private ProductDAO productDAO;
	
	//produces = MediaType.APPLICATION_JSON_VALUE
	@ResponseBody
	@RequestMapping(value="/mostsold", method=RequestMethod.GET)
	public Map<String,Object>  mostSold(){
		
		Map<String,Object> model = new HashMap<String,Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
		
		if(productDAO != null){
			//mais vendidos
			//final List<Product> mostSoldProducts = productDAO.list();
			
		}
		return model;
	}

}
