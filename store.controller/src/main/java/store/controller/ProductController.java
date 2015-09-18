package store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import store.infrastructure.dao.product.ProductDAO;
import store.model.product.Product;

@Transactional
@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	@ResponseBody
	@RequestMapping(value = "/mostsold", method = RequestMethod.GET)
	public List<Product> mostSold() {

		if (productDAO != null) {
			// mais vendidos
			return productDAO.list();

		}
		return null;
	}

}
