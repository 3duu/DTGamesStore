package store.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import store.controller.interfaces.IController;
import store.controller.interfaces.IHomeController;

@Controller
public class HomeController implements IHomeController {
	
	protected final String indexPage = "home";
	
	@RequestMapping(value="/")
	public String index(HttpServletRequest request) {
		return indexPage;
	}
}
