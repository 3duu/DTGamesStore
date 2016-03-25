package store.controller.user;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import store.controller.HomeController;
import store.controller.ViewModel;
import store.infrastructure.dao.product.UserDAO;
import store.model.user.User;


@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDetailsService users;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Login login;
	
	protected final String loginPage = "users/login";
	
	@RequestMapping
	public ViewModel redirectToAccount(HttpServletRequest request) {
		return new ViewModel(loginPage , request);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		return new ViewModel(loginPage, request);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ViewModel doLogin(User user, HttpServletRequest request) {
		
		final User u = (User) userDAO.loadUserByUsername(user.getUsername());
		if(u != null){
			if(u.getPassword().equals(user.getPassword())){
				this.login.setUser(u);
				return new ViewModel("redirect:" + HomeController.indexPage, request);
			}
		}
		return null;
	}
	
	@RequestMapping(value="/account")
	public ViewModel getAccountManagement(HttpServletRequest request) {
		return new ViewModel(HomeController.indexPage, request);
	}
	
	@RequestMapping("/data")
	public @ResponseBody Map<String, String> getUserData( HttpServletRequest request ) {
		
		Map<String, String> map = null;
		if(login != null && login.getUser() != null){
			map = new HashMap<String, String>();
			map.put("name", login.getUser().getName());
			map.put("username", login.getUser().getUserName());
		}
		
		return map;
	}
	
	
	
}
